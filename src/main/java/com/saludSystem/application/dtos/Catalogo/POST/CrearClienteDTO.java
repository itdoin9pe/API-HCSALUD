package com.saludSystem.application.dtos.Catalogo.POST;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CrearClienteDTO {

    private String tipoDocumento;

    private String nombre;

    private String direccion;

    private String contacto;

    @Schema(example = "999-888-555")
    private String telefono;

    @Schema(example = "user@gmail.com")
    private String email;;

    @Schema(description = "Estado del Cliente (0 = inactivo, 1 = activo)", example = "0")
    private Integer estado;

}