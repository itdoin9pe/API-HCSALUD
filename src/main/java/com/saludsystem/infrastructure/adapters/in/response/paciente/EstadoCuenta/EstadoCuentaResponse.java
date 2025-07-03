package com.saludsystem.infrastructure.adapters.in.response.paciente.EstadoCuenta;

import com.saludsystem.application.dtos.paciente.get.estadocuenta.EstadoCuentaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstadoCuentaResponse {

    @Schema(description = "Lista de registros del estado de cuenta del paciente")
    private List<EstadoCuentaDTO> data;

    @Schema(description = "Total de registros de estados de cuentas del paciente", example = "0")
    private long totalData;

}