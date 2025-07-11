package com.saludsystem.application.principal.dtos.get;

import com.saludsystem.application.dto.post.CrearInformacionClinicaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class InformacionClinicaDTO extends CrearInformacionClinicaDTO {

    private UUID informacionClinicaId;

}