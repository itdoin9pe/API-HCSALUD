package com.saludsystem.paciente.application.dto.get;

import com.saludsystem.paciente.application.dto.post.CrearRecetaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class RecetaDTO extends CrearRecetaDTO {

    private UUID pacienteRecetaId;

}