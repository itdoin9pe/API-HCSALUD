package com.saludsystem.submodules.operaciones.model.dtos.get;

import com.saludsystem.submodules.operaciones.model.dtos.post.CrearPresentacionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PresentacionDTO extends CrearPresentacionDTO {

    private UUID presentacionId;

}