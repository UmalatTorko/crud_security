package ru.gordanov.service;

import ru.gordanov.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void save(Role role);

    Role getRoleByName(String role);
}
