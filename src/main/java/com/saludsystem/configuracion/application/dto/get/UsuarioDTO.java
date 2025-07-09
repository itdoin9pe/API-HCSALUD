package com.saludsystem.configuracion.application.dto.get;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioDTO {
    private UUID userId;
}