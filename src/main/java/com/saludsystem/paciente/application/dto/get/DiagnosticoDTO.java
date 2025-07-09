package com.saludsystem.paciente.application.dto.get;

import com.saludsystem.paciente.application.dto.post.CrearDiagnosticoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class DiagnosticoDTO extends CrearDiagnosticoDTO {

    private UUID pacienteDiagnosticoId;

}