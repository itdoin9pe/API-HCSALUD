package com.saludsystem.mantenimiento.application.dto.get;

import com.saludsystem.mantenimiento.application.dto.post.CrearCajaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CajaDTO extends CrearCajaDTO {
    private UUID cajaId;
}