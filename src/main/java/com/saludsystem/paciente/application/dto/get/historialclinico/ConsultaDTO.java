package com.saludsystem.paciente.application.dto.get.historialclinico;

import com.saludsystem.paciente.application.dto.post.historialclinico.CrearConsultaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class ConsultaDTO extends CrearConsultaDTO {

    protected UUID pacienteConsultaId;

}