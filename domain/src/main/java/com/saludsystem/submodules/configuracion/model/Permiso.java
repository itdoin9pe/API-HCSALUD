package com.saludsystem.submodules.configuracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class Permiso {
    private UUID id;
    private Boolean delete;
    private Boolean insert;
    private Boolean read;
    private Boolean update;
    private UUID rolId;
    private UUID menuId;
}