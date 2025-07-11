package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.dto.post.CrearTarifarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TarifarioDTO extends CrearTarifarioDTO {

    private UUID tarifarioId;

}