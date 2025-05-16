package com.saludSystem.application.dtos.Paciente.PUT.EstadoCuenta;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ActualizarEstadoCuentaDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID pec_estadoCuentaId;

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