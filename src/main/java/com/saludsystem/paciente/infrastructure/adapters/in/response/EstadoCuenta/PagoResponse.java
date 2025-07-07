package com.saludsystem.paciente.infrastructure.adapters.in.response.EstadoCuenta;

import com.saludsystem.paciente.application.dto.res.historialclinico.estadocuenta.PagoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PagoResponse {

    @Schema(description = "Lista de pagos registrado en el historial del paciente")
    private List<PagoDTO> data;

    @Schema(description = "Numero total de registros de pagos en el historial del paciente", example = "0")
    private long totalData;

}