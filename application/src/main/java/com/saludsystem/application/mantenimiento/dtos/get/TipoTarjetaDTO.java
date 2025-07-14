package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.mantenimiento.dtos.post.CrearTipoTarjetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoTarjetaDTO extends CrearTipoTarjetaDTO {

    private UUID tipoTarjetaId;

}