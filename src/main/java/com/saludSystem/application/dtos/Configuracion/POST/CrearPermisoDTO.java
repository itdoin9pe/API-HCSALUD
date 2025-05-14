package com.saludSystem.application.dtos.Configuracion.POST;

import lombok.Data;

import java.util.UUID;

@Data
public class CrearPermisoDTO {

    private UUID permisoId;
    private UUID hospitalId;
    private UUID userId;
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;

}