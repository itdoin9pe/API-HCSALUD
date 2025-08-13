package com.saludsystem.submodules.principal.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SucursalDTO {
    private UUID sucursalId;
    private String nombre;
    private String direccion;
    private boolean isDefault;
}
