package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,SCHOOLBOY,TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
