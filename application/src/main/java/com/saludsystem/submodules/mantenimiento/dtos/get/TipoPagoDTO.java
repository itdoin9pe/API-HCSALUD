package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTipoPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPagoDTO extends CrearTipoPagoDTO {

    private UUID tipoPagoId;

}