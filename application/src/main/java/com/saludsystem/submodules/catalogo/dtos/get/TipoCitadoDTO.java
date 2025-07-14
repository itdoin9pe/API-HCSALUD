package com.saludsystem.submodules.catalogo.dtos.get;

import com.saludsystem.submodules.catalogo.dtos.post.CrearTipoCitadoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoCitadoDTO extends CrearTipoCitadoDTO {
    private UUID tipoCitadoId;

    public TipoCitadoDTO(UUID id, String nombre, String color, Integer estado) {
        this.setTipoCitadoId(id);
        this.setNombre(nombre);
        this.setColor(color);
        this.setEstado(estado);
    }
}
