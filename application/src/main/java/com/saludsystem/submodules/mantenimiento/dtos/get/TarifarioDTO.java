package com.saludsystem.submodules.mantenimiento.dtos.get;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearTarifarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TarifarioDTO extends CrearTarifarioDTO {

    private UUID tarifarioId;

}