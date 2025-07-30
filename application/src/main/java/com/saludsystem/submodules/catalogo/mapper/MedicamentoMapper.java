package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.MedicamentoCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarMedicamentoDTO;
import com.saludsystem.submodules.catalogo.model.Medicamento;

import java.util.UUID;

public class MedicamentoMapper {

    public static Medicamento fromCreateDto(MedicamentoCreateCommand dto) {
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

    public static MedicamentoCreateCommand toDto(Medicamento model) {
        return new MedicamentoCreateCommand(model.getId(), model.getNombre(), model.getFormaFarmaceutica(),
                model.getConcentracion(), model.getContenido(), model.getEstado());
    }

}
