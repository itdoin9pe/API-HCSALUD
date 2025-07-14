package com.saludsystem.application.paciente.dtos.get;

import com.saludsystem.application.paciente.dtos.post.CrearRecetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RecetaDTO extends CrearRecetaDTO {

    private UUID pacienteRecetaId;

}