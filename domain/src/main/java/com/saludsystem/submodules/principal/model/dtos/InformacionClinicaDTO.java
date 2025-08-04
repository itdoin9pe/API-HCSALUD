package com.saludsystem.submodules.principal.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class InformacionClinicaDTO {

    private UUID informacionClinicaId;

    private String nombre;

    @Schema(description = "Estado de la aseguradora (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

    public InformacionClinicaDTO(UUID id, String nombre, Integer estado) {
        this.setInformacionClinicaId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }

}