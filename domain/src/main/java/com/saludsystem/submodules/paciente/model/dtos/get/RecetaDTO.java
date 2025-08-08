package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RecetaDTO {

    private UUID pacienteRecetaId;

    private UUID pacienteId;

    private UUID doctorId;

    private LocalDate fecha;

    private String observaciones;

    @Schema(example = "0")
    private Integer estado;

    private List<MedicamentoRecetadoDTO> medicamentos;

    public RecetaDTO(UUID pacienteRecetaId, LocalDate fecha, UUID doctorId, UUID pacienteId,
                     String observaciones, Integer estado, List<MedicamentoRecetadoDTO> dtoList) {
        this.setPacienteRecetaId(pacienteRecetaId);
        this.setFecha(fecha);
        this.setDoctorId(doctorId);
        this.setPacienteId(pacienteId);
        this.setObservaciones(observaciones);
        this.setEstado(estado);
        this.setMedicamentos(dtoList);
    }
}