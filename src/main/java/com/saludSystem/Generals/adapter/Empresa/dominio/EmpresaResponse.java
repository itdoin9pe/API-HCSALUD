package com.saludSystem.Generals.adapter.Empresa.dominio;

import com.saludSystem.Generals.adapter.Empresa.aplicacion.dtos.EmpresaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmpresaResponse {

    @Schema(description = "Lista de Empresas")
    private List<EmpresaDTO> data;

    @Schema(description = "Número total de Empresas", example = "0")
    private long totalData;

}
