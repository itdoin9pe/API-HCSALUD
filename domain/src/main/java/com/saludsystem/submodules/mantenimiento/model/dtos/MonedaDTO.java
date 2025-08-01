package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.MonedaCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(callSuper = false)
public class MonedaDTO extends MonedaCreateCommand {

    private UUID monedaId;

    public MonedaDTO(UUID id, String descripcion, Integer estado) {
        this.setMonedaId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}