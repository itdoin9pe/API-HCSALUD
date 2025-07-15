package com.saludsystem.submodules.configuracion.model.dto;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class JwtResponse {
    private String token;
    private UUID id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, UUID id, String username, String email, List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
