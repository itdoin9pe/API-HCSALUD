package com.saludsystem.submodules.principal.dtos.get;

import com.saludsystem.submodules.principal.dtos.post.CrearEmpresaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpresaDTO extends CrearEmpresaDTO {

    private UUID empresaId;

}