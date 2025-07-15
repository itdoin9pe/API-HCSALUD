package com.saludsystem.submodules.configuracion.model.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class JwtResponse {
    private String token;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, String email, List<String> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }
}
