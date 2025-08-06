package com.saludsystem.submodules.paciente.model.dtos.command.create;

import com.saludsystem.submodules.paciente.model.dtos.get.MedicamentoRecetadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecetaCreateCommand {

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

    private List<MedicamentoRecetadoDTO> medicamentos;

}