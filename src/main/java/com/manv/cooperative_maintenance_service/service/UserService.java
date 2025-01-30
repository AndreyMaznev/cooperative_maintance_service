package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.exception.user.EmailAlreadyInUseException;
import com.manv.cooperative_maintenance_service.exception.user.UserIdNotEqualsException;
import com.manv.cooperative_maintenance_service.exception.user.UserNotFoundException;
import com.manv.cooperative_maintenance_service.exception.user.UsernameAlreadyInUseException;
import com.manv.cooperative_maintenance_service.model.Role;
import com.manv.cooperative_maintenance_service.model.DTO.UserDTO;
import com.manv.cooperative_maintenance_service.model.UserMapper;
import com.manv.cooperative_maintenance_service.repository.UserRepository;

import com.manv.cooperative_maintenance_service.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final ModelMapper modelMapper;


    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyInUseException("Пользователь с таким именем уже существует");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyInUseException("Пользователь с таким email уже существует");
        }
        return saveUser(user);
    }

    public UserDTO createUserByDto(UserDTO userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new UsernameAlreadyInUseException("Пользователь с таким именем уже существует");
        }
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailAlreadyInUseException("Пользователь с таким email уже существует");
        }
        saveUser (userMapper.toEntity(userDto));
        return userDto;
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    public UserDTO getUserDtoByUsername(String username) {
        return userRepository.findByUsername(username).map(user -> userMapper.toDto(user))
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::getUserByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUsername(username);
    }

    /**
     * Запрос прав администратора для текущего пользователя
     * <p>
     */

    public void getAdmin() {
        //todo new requests table with user name, requests date, boolean accepted by head admin
        //todo new admin controller with requests table - on click - role changing for user
        var user = getCurrentUser();
        user.setRole(Role.ROLE_ADMIN);
        saveUser(user);
    }


    public List<User> getAllUserList() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return Collections.emptyList();
        }
        return userList;
    }

    public List<UserDTO> getAllUserDTOList() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return Collections.emptyList();
        }
        return userList.stream().map(user -> userMapper.toDto(user)).collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("Пользователь не найден.");
        }
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> (new UserNotFoundException("Пользователь не найден.")));
    }


    public boolean checkIdAreEquals (Long id, User person){
        if (!person.getId().equals(id)) {
            throw new UserIdNotEqualsException("Id not equals");
        }
        return true;
    }

    public boolean checkIncomingUserNotNull (User user){
        return user != null;
    }


    public User update(Long id, User user) {
        if (userRepository.existsById(id) && checkIdAreEquals(id,user) && checkIncomingUserNotNull(user)) {
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User not found");
        }
    }
}