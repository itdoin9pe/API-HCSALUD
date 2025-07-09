package com.saludsystem.paciente.application.dto.put.historialclinico.estadocuenta;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarEstadoCuentaDTO extends BaseDTO {

    private UUID pacEstadoCuentaId;

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