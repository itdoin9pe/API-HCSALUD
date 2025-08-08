package com.saludsystem.submodules.configuracion.model.dtos.command;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PermisoCreateCommand {
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;
}