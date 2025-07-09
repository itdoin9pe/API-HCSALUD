package com.saludsystem.paciente.application.dto.get.historialclinico;

import com.saludsystem.paciente.application.dto.post.historialclinico.CrearAntecedenteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AntecedenteDTO extends CrearAntecedenteDTO {

    private UUID pacEnfermedadActualId;

}