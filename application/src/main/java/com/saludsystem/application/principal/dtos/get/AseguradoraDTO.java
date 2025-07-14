package com.saludsystem.application.principal.dtos.get;

import com.saludsystem.application.principal.dtos.post.CrearAseguradoraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AseguradoraDTO extends CrearAseguradoraDTO {

    private UUID aseguradoraId;

}