package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class EstudioMedicoDTO  {

    @Schema(example = "Integer")
    private Long pacienteEstudioMedicoId;

    private String tipo;

    private String descripcion;

    private LocalDateTime requestAt;

    private LocalDateTime performedAt;

    private String estado;

    private UUID pacienteId;

    private UUID doctorId;

    @Schema(example = "Integer")
    private Long pacienteEstudioResultadoId;

    public EstudioMedicoDTO(Long id, String descripcion, String estado, UUID pacienteId,
                            UUID doctorId, Long estudioResultadoId) {
        this.setPacienteEstudioMedicoId(id);
        this.setDescripcion(descripcion);
        this.setEstado(estado);
        this.setPacienteId(pacienteId);
        this.setDoctorId(doctorId);
        this.setPacienteEstudioResultadoId(estudioResultadoId);
    }
}