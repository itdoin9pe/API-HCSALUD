package com.saludsystem.submodules.principal.mapper;

import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.principal.model.dtos.get.TipoPacienteDTO;
import com.saludsystem.submodules.principal.model.dtos.post.CrearTipoPacienteDTO;
import com.saludsystem.submodules.principal.model.dtos.put.ActualizarTipoPacienteDTO;

public class TipoPacienteMapper {

    public static TipoPaciente fromCreateDto(CrearTipoPacienteDTO dto){
        return new TipoPaciente(null, dto.getNombre());
    }

    public static TipoPaciente fromUpdateDto(Long id, ActualizarTipoPacienteDTO dto){
        return new TipoPaciente(id, dto.getNombre());
    }

    public static TipoPacienteDTO toDto(TipoPaciente model) {
        return new TipoPacienteDTO(
                model.getId(),
                model.getNombre());
    }

}
