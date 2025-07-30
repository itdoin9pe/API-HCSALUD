package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPagoDTO extends CrearTipoPagoDTO {

    private UUID tipoPagoId;

    public TipoPagoDTO(UUID tipoPagoId, String descripcion, String metodoPago, Integer estado) {
        this.setTipoPagoId(tipoPagoId);
        this.setDescripcion(descripcion);
        this.setMetodoPago(metodoPago);
        this.setEstado(estado);
    }
}