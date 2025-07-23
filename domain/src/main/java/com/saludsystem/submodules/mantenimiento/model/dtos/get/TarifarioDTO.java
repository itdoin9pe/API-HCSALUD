package com.saludsystem.submodules.mantenimiento.model.dtos.get;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTarifarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TarifarioDTO extends CrearTarifarioDTO {

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