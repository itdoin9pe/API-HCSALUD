package com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InformeInterconsultaEditCommand extends BaseDTO {

    private UUID pacienteInformeInterconsultaId;

    private UUID pacienteInterconsultaId;

    private UUID medicoResponsable;

    private LocalDateTime fecha;

    private String resumenClinico;

    private String diagnostico;

    private String recomendaciones;

    private String archivoAdjuntoUrl;

}
