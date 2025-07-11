package com.saludsystem.application.paciente.dtos.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarRecetaDTO extends BaseDTO {

    private UUID pacienteRecetaId;

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

}
