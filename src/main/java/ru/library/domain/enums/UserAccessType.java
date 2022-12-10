package ru.library.domain.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserAccessType implements GrantedAuthority {
    ADMIN("ADMIN"),
    USER ("USER");

    private final String name;

    private UserAccessType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getAuthority()  {
        return "ROLE_" + name();
    }
}
