package com.saludsystem.principal.application.dto.get;

import com.saludsystem.principal.application.dto.post.CrearEmpresaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EmpresaDTO extends CrearEmpresaDTO {

    private UUID empresaId;

}