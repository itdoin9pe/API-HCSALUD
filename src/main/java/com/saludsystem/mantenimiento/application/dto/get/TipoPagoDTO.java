package com.saludsystem.mantenimiento.application.dto.get;

import com.saludsystem.mantenimiento.application.dto.post.CrearTipoPagoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoPagoDTO extends CrearTipoPagoDTO {

    private UUID tipoPagoId;

}