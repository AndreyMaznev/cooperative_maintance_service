package com.manv.cooperative_maintenance_service.security;


import com.manv.cooperative_maintenance_service.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


public class PersonDetails implements UserDetails {

    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(person.getRole()));
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        //todo
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //todo
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //todo
        return true;
    }

    @Override
    public boolean isEnabled() {
        //todo

        return true;
    }

    public Person getPerson() {
        return person;
    }
}
