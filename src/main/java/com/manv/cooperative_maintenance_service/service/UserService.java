package com.manv.cooperative_maintenance_service.service;

import com.manv.cooperative_maintenance_service.exception.EmailAlreadyInUseException;
import com.manv.cooperative_maintenance_service.exception.UsernameAlreadyInUseException;
import com.manv.cooperative_maintenance_service.model.Role;
import com.manv.cooperative_maintenance_service.repository.UserRepository;

import com.manv.cooperative_maintenance_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserRepository userRepository;

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    public User save(User user) {
        return repository.save(user);
    }


    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    public User create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyInUseException("Пользователь с таким именем уже существует");
        }
        if (repository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyInUseException("Пользователь с таким email уже существует");
        }
        return save(user);
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    public User getByUsername(String username) {
        return repository.findByUsername(username)
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
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
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
        save(user);
    }


    public List<User> getAllPersonList() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return Collections.emptyList();
        }
        return userList;
    }

    public User createNewPerson(User user) {
        RestPreconditions.checkNotNull(user);
        userRepository.save(user);
        return user;
    }


//    public ResponseEntity<User> deletePerson(UUID uuid) {
//        RestPreconditions.checkNotNull(userRepository.delete(uuid););
//        userRepository.deleteByUuid(uuid);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }
//
//
//    public ResponseEntity<User> update (UUID uuid, User person) {
//        RestPreconditions.checkNotNull(personRepository.findByUuid(uuid));
//        RestPreconditions.checkNotNull(person);
//        RestPreconditions.checkThatUuidAreEquals(uuid, person.getUuid());
//        personRepository.save(person);
//        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
//    }


}