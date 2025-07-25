package com.saludsystem.submodules.paciente.model.dtos.get.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.post.historialclinico.CrearAntecedenteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AntecedenteDTO extends CrearAntecedenteDTO {

    private UUID pacEnfermedadActualId;

}