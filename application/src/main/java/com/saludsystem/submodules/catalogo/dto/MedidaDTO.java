package com.saludsystem.submodules.catalogo.dto;

import com.saludsystem.submodules.catalogo.dto.command.CrearMedidaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedidaDTO extends CrearMedidaDTO {
    private UUID medidaId;

    public MedidaDTO(UUID id, String nombre, Integer estado) {
        this.setMedidaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}