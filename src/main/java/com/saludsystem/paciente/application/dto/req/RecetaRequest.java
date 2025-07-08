package com.saludsystem.paciente.application.dto.req;

import com.saludsystem.paciente.application.dto.res.MedicamentoRecetadoResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class RecetaRequest {

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

    private List<MedicamentoRecetadoResponse> medicamentos;

}