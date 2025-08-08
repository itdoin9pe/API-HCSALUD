package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecetaDTO {

    private UUID pacienteRecetaId;

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

    private List<MedicamentoRecetadoDTO> medicamentos;

}