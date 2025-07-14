package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.mantenimiento.dtos.post.CrearMonedaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MonedaDTO extends CrearMonedaDTO {

    private UUID monedaId;

}