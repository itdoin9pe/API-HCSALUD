package com.saludsystem.principal.application.dto.get;

import com.saludsystem.principal.application.dto.post.CrearEstudioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class EstudioDTO extends CrearEstudioDTO {

    private UUID estudioId;

}