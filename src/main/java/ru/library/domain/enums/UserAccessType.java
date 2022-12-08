package ru.library.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserAccessType implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority()  {
        return "ROLE_" + name();
    }
}
