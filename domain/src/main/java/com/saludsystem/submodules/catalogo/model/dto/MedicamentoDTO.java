package com.saludsystem.submodules.catalogo.model.dto;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearMedicamentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoDTO extends CrearMedicamentoDTO {
    private UUID medicamentoId;

    public MedicamentoDTO(
            UUID id, String nombre, String formaFarmaceutica,
            String concentracion, String contenido, Integer estado) {
        this.setMedicamentoId(id);
        this.setNombre(nombre);
        this.setConcentracion(concentracion);
        this.setContenido(contenido);
        this.setEstado(estado);
    }
}