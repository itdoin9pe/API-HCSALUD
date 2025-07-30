package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearBancoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class BancoDTO extends CrearBancoDTO {
    private UUID bancoId;

    public BancoDTO(UUID id, String descripcion, Integer estado) {
        this.setBancoId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
    }
}