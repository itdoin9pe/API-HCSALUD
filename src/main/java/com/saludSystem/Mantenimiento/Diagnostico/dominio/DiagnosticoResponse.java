package com.saludSystem.Mantenimiento.Diagnostico.dominio;

import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.DiagnosticoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DiagnosticoResponse {

    @Schema(description = "Lista de Diagnosticos")
    private List<DiagnosticoDTO> data;

    @Schema(description = "Numero total de Diagnosticos registrados")
    private long totalData;

}