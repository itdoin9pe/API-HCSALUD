package com.saludsystem.submodules.mantenimiento.model.dtos;

import com.saludsystem.submodules.mantenimiento.model.dtos.command.TarifarioCreateCommand;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor@EqualsAndHashCode(callSuper = false)
public class TarifarioDTO extends TarifarioCreateCommand {

    private UUID tarifarioId;

    public TarifarioDTO(UUID id, UUID tipoConceptoId, UUID categoriaId, UUID medidaId,
                        UUID unidadId, String grupo, String descripcion, Double precio,
                        Integer estado) {
        this.setTarifarioId(id);
        this.setTipoConceptoId(tipoConceptoId);
        this.setCategoriaId(categoriaId);
        this.setMedidaId(medidaId);
        this.setUnidadId(unidadId);
        this.setGrupo(grupo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setEstado(estado);
    }
}