package com.saludsystem.application.catalogo.dtos.get;

import com.saludsystem.application.catalogo.dtos.post.CrearTipoCitadoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoCitadoDTO extends CrearTipoCitadoDTO {
    private UUID tipoCitadoId;
}
