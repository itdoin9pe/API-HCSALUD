package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearCajaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CajaDTO extends CrearCajaDTO {
    private UUID cajaId;
}