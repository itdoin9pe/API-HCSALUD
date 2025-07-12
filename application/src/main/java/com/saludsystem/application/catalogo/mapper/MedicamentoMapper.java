package com.saludsystem.application.catalogo.mapper;

import com.saludsystem.application.catalogo.dtos.get.MedicamentoDTO;
import com.saludsystem.application.catalogo.dtos.post.CrearMedicamentoDTO;
import com.saludsystem.application.catalogo.dtos.put.ActualizarMedicamentoDTO;
import com.saludsystem.domain.catalogo.model.Medicamento;

import java.util.UUID;

public class MedicamentoMapper {

    public static Medicamento fromCreateDto(CrearMedicamentoDTO dto) {
        return new Medicamento(null, dto.getNombre(), dto.getFormaFarmaceutica(), dto.getConcentracion(),
                dto.getContenido(), dto.getEstado());
    }

    public static Medicamento fromUpdateDto(UUID uuid, ActualizarMedicamentoDTO dto) {
        return new Medicamento(uuid, dto.getNombre(),
                dto.getFormaFarmaceutica(),
                dto.getConcentracion(),
                dto.getContenido(),
                dto.getEstado());
    }

    public static MedicamentoDTO toDto(Medicamento model) {
        return new MedicamentoDTO(model.getId(), model.getNombre(), model.getFormaFarmaceutica(),
                model.getConcentracion(), model.getContenido(), model.getEstado());
    }

}
