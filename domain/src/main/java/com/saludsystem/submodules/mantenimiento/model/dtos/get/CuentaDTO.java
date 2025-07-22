package com.saludsystem.submodules.mantenimiento.model.dtos.get;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearCuentaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class CuentaDTO extends CrearCuentaDTO {
    private UUID cuentaPagarId;

    public CuentaDTO(UUID id, String nombre, Integer total, Integer estado) {
        this.setCuentaPagarId(id);
        this.setNombre(nombre);
        this.setTotal(total);
        this.setEstado(estado);
    }
}