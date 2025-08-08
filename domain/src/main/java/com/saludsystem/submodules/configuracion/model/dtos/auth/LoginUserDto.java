package com.saludsystem.submodules.configuracion.model.dtos.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginUserDto {
    private String email;
    private String password;
}
