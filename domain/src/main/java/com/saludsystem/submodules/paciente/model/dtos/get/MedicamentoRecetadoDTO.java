package com.saludsystem.submodules.paciente.model.dtos.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class MedicamentoRecetadoDTO {

    private UUID medicamentoRecetadoId;

    private UUID pacienteRecetaId;

    private UUID medicamentoId;

    private String dosis;

    private String frecuencia;

    @Schema(example = "0")
    private Integer duracionDias;

    private String indicaciones;

    public MedicamentoRecetadoDTO(UUID id, UUID pacienteRecetaId, UUID medicamentoId, String dosis,
                                  String frecuencia, Integer duracionDias, String indicaciones) {
        this.setMedicamentoId(id);
        this.setPacienteRecetaId(pacienteRecetaId);
        this.setMedicamentoId(medicamentoId);
        this.setDosis(dosis);
        this.setFrecuencia(frecuencia);
        this.setDuracionDias(duracionDias);
        this.setIndicaciones(indicaciones);
    }
}