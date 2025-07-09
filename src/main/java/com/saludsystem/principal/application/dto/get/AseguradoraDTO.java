package com.saludsystem.principal.application.dto.get;

import com.saludsystem.principal.application.dto.post.CrearAseguradoraDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class AseguradoraDTO extends CrearAseguradoraDTO {

    private UUID aseguradoraId;

}