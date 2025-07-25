package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearEstudioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudioDTO extends CrearEstudioDTO {

    private UUID estudioId;

}