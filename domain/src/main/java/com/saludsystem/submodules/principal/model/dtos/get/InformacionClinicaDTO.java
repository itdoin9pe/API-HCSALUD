package com.saludsystem.submodules.principal.model.dtos.get;

import com.saludsystem.submodules.principal.model.dtos.post.CrearInformacionClinicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class InformacionClinicaDTO extends CrearInformacionClinicaDTO {

    private UUID informacionClinicaId;

}