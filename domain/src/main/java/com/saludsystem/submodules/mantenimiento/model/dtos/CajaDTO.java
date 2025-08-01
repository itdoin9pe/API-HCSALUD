package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.CajaCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CajaDTO extends CajaCreateCommand {
    private UUID cajaId;

    public CajaDTO(UUID id, String nombre, Integer estado) {
        this.setCajaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}