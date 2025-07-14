package com.saludsystem.application.paciente.dtos.get.historialclinico;

import com.saludsystem.application.paciente.dtos.post.historialclinico.CrearConsultaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConsultaDTO extends CrearConsultaDTO {

    protected UUID pacienteConsultaId;

}