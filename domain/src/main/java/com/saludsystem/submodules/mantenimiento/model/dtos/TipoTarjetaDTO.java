package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoTarjetaCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(callSuper = false)
public class TipoTarjetaDTO extends TipoTarjetaCreateCommand {

    private UUID tipoTarjetaId;

    public TipoTarjetaDTO(UUID tipoTarjetaId, String descripcion, Integer estado) {
        this.setTipoTarjetaId(tipoTarjetaId);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}