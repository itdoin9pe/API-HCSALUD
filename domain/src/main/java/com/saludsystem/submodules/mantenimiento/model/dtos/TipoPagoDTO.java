package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoPagoCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(callSuper = false)
public class TipoPagoDTO extends TipoPagoCreateCommand {

    private UUID tipoPagoId;

    public TipoPagoDTO(UUID tipoPagoId, String descripcion, String metodoPago, Integer estado) {
        this.setTipoPagoId(tipoPagoId);
        this.setDescripcion(descripcion);
        this.setMetodoPago(metodoPago);
        this.setEstado(estado);
    }
}