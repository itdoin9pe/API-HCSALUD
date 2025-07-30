package com.saludsystem.submodules.paciente.dtos.get;

import com.saludsystem.submodules.paciente.dtos.post.CrearDiagnosticoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DiagnosticoDTO extends CrearDiagnosticoDTO {

    private UUID pacienteDiagnosticoId;

}