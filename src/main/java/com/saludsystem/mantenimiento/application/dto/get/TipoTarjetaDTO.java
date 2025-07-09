package com.saludsystem.mantenimiento.application.dto.get;

import com.saludsystem.mantenimiento.application.dto.post.CrearTipoTarjetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoTarjetaDTO extends CrearTipoTarjetaDTO {

    private UUID tipoTarjetaId;

}