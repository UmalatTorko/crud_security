package ru.gordanov.config;

import org.springframework.stereotype.Component;
import ru.gordanov.model.Role;
import ru.gordanov.model.User;
import ru.gordanov.service.RoleService;
import ru.gordanov.service.UserService;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {

    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {
        roleService.save(new Role("ROLE_ADMIN"));
        roleService.save(new Role("ROLE_USER"));

        User user = new User();
        user.setName("Admin");
        user.setSurname("Adminov");
        user.setEmail("admin@gmail.com");
        user.setUsername("admin");
        user.setPassword("admin");
        user.setRoles(Set.of(roleService.getRoleByName("ROLE_ADMIN"), roleService.getRoleByName("ROLE_USER")));
        userService.save(user);

        User user2 = new User();
        user2.setName("User");
        user2.setSurname("Userov");
        user2.setEmail("user@gmail.com");
        user2.setUsername("user");
        user2.setPassword("user");
        user2.setRoles(Set.of(roleService.getRoleByName("ROLE_USER")));
        userService.save(user2);
    }
}
