package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.CuentaCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CuentaDTO extends CuentaCreateCommand {
    private UUID cuentaPagarId;

    public CuentaDTO(UUID id, String nombre, Integer total, Integer estado) {
        this.setCuentaPagarId(id);
        this.setNombre(nombre);
        this.setTotal(total);
        this.setEstado(estado);
    }
}