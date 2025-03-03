package com.saludSystem.infraestructura.controllers;
/*
import com.saludSystem.enums.UserRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/auth")
public class RoleController {

    @GetMapping("/GetAllRoles")
    public Map<String, Integer> getRolesOrdered() {
        UserRole[] roles = UserRole.values();
        Map<String, Integer> orderedRoles = new LinkedHashMap<>();
        IntStream.range(0, roles.length)
                .forEach(i -> orderedRoles.put(roles[i].name(), i));
        return orderedRoles;
    }

}
*/