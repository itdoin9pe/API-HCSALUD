package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.BancoCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class BancoDTO extends BancoCreateCommand {
    private UUID bancoId;

    public BancoDTO(UUID id, String descripcion, Integer estado) {
        this.setBancoId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}