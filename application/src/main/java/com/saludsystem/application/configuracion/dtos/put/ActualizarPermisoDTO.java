package com.saludsystem.application.configuracion.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarPermisoDTO extends BaseDTO {
    private UUID permisoId;
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;
}