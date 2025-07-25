package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearEmpresaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpresaDTO extends CrearEmpresaDTO {

    private UUID empresaId;

}