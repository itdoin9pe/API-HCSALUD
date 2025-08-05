package com.saludsystem.submodules.configuracion.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class SedeDTO {
    private UUID sedeId;
    private String codigo;
    private String nombre;
    private String direccion;
    private String ubigeo;
    @Schema(description = "Estado de la sede (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

    public SedeDTO(String codigo, String nombre, String direccion, String ubigeo, Integer estado) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setUbigeo(ubigeo);
        this.setEstado(estado);
    }

}