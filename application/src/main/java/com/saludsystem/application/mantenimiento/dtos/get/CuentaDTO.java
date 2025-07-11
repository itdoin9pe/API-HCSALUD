package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearCuentaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CuentaDTO extends CrearCuentaDTO {
    private UUID cuentaPagarId;
}