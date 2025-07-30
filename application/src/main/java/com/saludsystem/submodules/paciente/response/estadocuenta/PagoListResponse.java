package com.saludsystem.submodules.paciente.response.estadocuenta;

import com.saludsystem.submodules.paciente.dtos.get.historialclinico.estadocuenta.PagoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PagoListResponse {

    @Schema(description = "Lista de pagos registrado en el historial del paciente")
    private List<PagoDTO> data;

    @Schema(description = "Numero total de registros de pagos en el historial del paciente", example = "0")
    private long totalData;

}