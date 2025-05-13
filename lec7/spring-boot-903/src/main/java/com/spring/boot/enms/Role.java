package com.spring.boot.enms;

public enum Role {
    USER("USER"),
    ADMIN("ADMIN");

    private final String roleName;
    Role(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
