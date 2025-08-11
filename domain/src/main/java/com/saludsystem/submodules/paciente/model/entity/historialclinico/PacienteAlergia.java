package com.saludsystem.submodules.paciente.model.entity.historialclinico;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class PacienteAlergia {

    private UUID pacienteAlergiaId;
    private UUID pacienteEntity;
    private UUID alergiaEntity;
    private String observacion;
    private Integer estado;

}
