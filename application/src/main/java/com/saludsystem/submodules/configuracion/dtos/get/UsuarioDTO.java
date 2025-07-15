package com.saludsystem.submodules.configuracion.dtos.get;

import com.saludsystem.submodules.configuracion.dtos.post.NewUserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO extends NewUserDto {
    private UUID userId;
}