package com.saludsystem.submodules.paciente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Receta {
    private UUID pacienteRecetaId;
    private LocalDate fecha;
    private UUID doctorId;
    private UUID pacienteId;
    private String observaciones;
    private Integer estado;
    private List<MedicamentoRecetado> medicamentosRecetados;
}
