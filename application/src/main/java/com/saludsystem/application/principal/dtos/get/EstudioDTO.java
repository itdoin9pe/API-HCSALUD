package com.saludsystem.application.principal.dtos.get;

import com.saludsystem.application.principal.dtos.post.CrearEstudioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudioDTO extends CrearEstudioDTO {

    private UUID estudioId;

}