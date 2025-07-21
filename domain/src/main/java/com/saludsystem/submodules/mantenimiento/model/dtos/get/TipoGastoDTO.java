package com.saludsystem.submodules.mantenimiento.model.dtos.get;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoGastoDTO {

    private UUID conceptoGastoId;

}