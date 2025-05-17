package com.spring.boot.enums;

public enum RoleSystem {

    ADMIN("ADMIN"),
    USER("USER");

    private final String roleName;

    RoleSystem(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}
