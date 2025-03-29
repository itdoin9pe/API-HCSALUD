package com.saludSystem.Mantenimiento.Banco.dominio;

import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.BancoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BancoResponse {

    @Schema(description = "Lista de Bancos")
    private List<BancoDTO> data;

    @Schema(description = "Número total de bancos", example = "0")
    private long totalData;

}