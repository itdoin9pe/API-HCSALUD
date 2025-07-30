package com.saludsystem.submodules.catalogo.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedicamentoCreateCommand extends com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand {
    private UUID medicamentoId;

    public MedicamentoCreateCommand(
            UUID id, String nombre, String formaFarmaceutica,
            String concentracion, String contenido, Integer estado) {
        this.setMedicamentoId(id);
        this.setNombre(nombre);
        this.setConcentracion(concentracion);
        this.setContenido(contenido);
        this.setEstado(estado);
    }
}