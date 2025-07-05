package com.saludsystem.application.dtos.paciente.get.estadocuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EstadoCuentaDTO {

    private UUID pacEstadpCuentaId;

    private UUID pacienteId;

    private Date fechaApertura;

    private String estado;

    @Schema(example = "0")
    private Double totalHospitalizacion;

    @Schema(example = "0")
    private Double totalMedicamentosEstudios;

    @Schema(example = "0")
    private Double totalPagado;

    @Schema(example = "0")
    private Double saldoPendiente;

}