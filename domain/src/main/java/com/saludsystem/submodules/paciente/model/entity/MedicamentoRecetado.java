package com.saludsystem.submodules.paciente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class MedicamentoRecetado {

    private UUID id;
    private UUID pacienteRecetaId;
    private UUID medicamentoId;
    private String dosis;
    private String frecuencia;
    private Integer duracionDias;
    private String indicaciones;

}
