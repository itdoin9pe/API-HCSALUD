package com.saludsystem.submodules.catalogo.dtos.get;

import com.saludsystem.submodules.catalogo.dtos.post.CrearTipoConceptoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class TipoConceptoDTO extends CrearTipoConceptoDTO {
    private UUID tipoConceptoId;

    public TipoConceptoDTO(UUID id, String nombre, Integer estado) {
        this.setTipoConceptoId(id);
        this.setNombre(nombre);
        this.setEstado(estado);
    }
}