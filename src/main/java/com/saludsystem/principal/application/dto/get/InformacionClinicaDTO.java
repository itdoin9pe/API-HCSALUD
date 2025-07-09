package com.saludsystem.principal.application.dto.get;

import com.saludsystem.principal.application.dto.post.CrearInformacionClinicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class InformacionClinicaDTO extends CrearInformacionClinicaDTO {

    private UUID informacionClinicaId;

}