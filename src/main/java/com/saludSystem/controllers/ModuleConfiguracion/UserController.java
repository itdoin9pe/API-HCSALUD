package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.User.UserDTO;
import com.saludSystem.services.modules.configuration.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/GetUsuarioList")
    public ResponseEntity<List<UserDTO>> getAllList() {
        return ResponseEntity.ok(userService.getUserList());
    }


}
