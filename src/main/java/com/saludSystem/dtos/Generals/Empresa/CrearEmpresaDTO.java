package com.saludSystem.dtos.Generals.Empresa;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CrearEmpresaDTO {

    //private UUID hospitalId;
    private String descripcion;
    @Min(value = 0)
    @Max(value = 1)
    @Schema(description = "Estado de la empresa (0 = inactivo, 1 = activo)", example = "0", defaultValue = "0")
    private Integer estado;

    public CrearEmpresaDTO(
            //UUID hospitalId,
            String descripcion, Integer estado) {
        //this.hospitalId = hospitalId;
        this.descripcion = descripcion;
        this.estado = estado;
    }

}
