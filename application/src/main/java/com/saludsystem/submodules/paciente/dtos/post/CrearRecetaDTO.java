package com.saludsystem.submodules.paciente.dtos.post;

import com.saludsystem.submodules.paciente.dtos.get.MedicamentoRecetadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class CrearRecetaDTO {

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

    private List<MedicamentoRecetadoDTO> medicamentos;

}