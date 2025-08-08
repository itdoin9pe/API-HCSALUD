package com.saludsystem.submodules.paciente.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class EstudioMedico {

    private Long id;
    private String tipo;
    private String descripcion;
    private String estado;
    private UUID pacienteId;
    private UUID doctorId;
    private Long estudioResultadoId;

}
