package com.saludsystem.submodules.catalogo.model.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MedicamentoDTO extends com.saludsystem.submodules.catalogo.model.dto.command.MedicamentoCreateCommand {
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