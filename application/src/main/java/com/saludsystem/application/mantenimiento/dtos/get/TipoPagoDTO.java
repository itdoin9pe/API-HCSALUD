package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.mantenimiento.dtos.post.CrearTipoPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPagoDTO extends CrearTipoPagoDTO {

    private UUID tipoPagoId;

}