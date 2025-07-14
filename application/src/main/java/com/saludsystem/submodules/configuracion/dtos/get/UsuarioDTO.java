package com.saludsystem.submodules.configuracion.dtos.get;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO {
    private UUID userId;
}