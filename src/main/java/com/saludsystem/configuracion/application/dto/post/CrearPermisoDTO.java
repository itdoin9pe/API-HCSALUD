package com.saludsystem.configuracion.application.dto.post;

import lombok.Data;

import java.util.UUID;

@Data
public class CrearPermisoDTO {
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;
}