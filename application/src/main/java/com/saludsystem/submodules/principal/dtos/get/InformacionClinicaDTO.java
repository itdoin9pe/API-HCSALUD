package com.saludsystem.submodules.principal.dtos.get;

import com.saludsystem.submodules.principal.dtos.post.CrearInformacionClinicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class InformacionClinicaDTO extends CrearInformacionClinicaDTO {

    private UUID informacionClinicaId;

}