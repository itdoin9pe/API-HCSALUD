package com.saludSystem.Configuracion.Usuario.aplicacion.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    public String email;
    public String password;
}
