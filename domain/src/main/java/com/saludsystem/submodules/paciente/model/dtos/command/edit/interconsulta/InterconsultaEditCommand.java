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
public class InterconsultaEditCommand extends BaseDTO {

    private UUID pacienteInterconsultaId;

    private UUID pacienteId;

    private UUID medicoSolicitante;

    private UUID especialidadDestino;

    private String motivo;

    private LocalDateTime fechaSolicitud;

    private String estado;

    private String prioridad;

    private String observaciones;

    private LocalDateTime fechaAtencion;

}
