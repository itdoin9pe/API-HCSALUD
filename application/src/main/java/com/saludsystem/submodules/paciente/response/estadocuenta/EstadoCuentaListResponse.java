package com.saludsystem.submodules.paciente.response.estadocuenta;

import com.saludsystem.submodules.paciente.dtos.get.historialclinico.estadocuenta.EstadoCuentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstadoCuentaListResponse {

    @Schema(description = "Lista de registros del estado de cuenta del paciente")
    private List<EstadoCuentaDTO> data;

    @Schema(description = "Total de registros de estados de cuentas del paciente", example = "0")
    private long totalData;

}