package com.saludsystem.submodules.configuracion.model.dtos.command.edit;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PermisoEditCommand extends BaseDTO {
    private UUID permisoId;
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;
}