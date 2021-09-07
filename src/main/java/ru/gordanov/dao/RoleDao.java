package ru.gordanov.dao;

import ru.gordanov.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();

    void save(Role role);

    Role getRoleByName(String role);
}
