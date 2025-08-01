package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoGastoCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(callSuper = false)
public class TipoGastoDTO extends TipoGastoCreateCommand {

    private UUID conceptoGastoId;

    public TipoGastoDTO(UUID conceptoGastoId, String nombre, Integer estado) {
        this.setConceptoGastoId(conceptoGastoId);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}