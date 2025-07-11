package com.saludsystem.application.operaciones.dtos.get;

import com.saludsystem.application.dto.post.CrearPresentacionDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PresentacionDTO extends CrearPresentacionDTO {

    private UUID presentacionId;

}