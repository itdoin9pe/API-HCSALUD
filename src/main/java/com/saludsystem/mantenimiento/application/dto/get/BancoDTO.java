package com.saludsystem.mantenimiento.application.dto.get;

import com.saludsystem.mantenimiento.application.dto.post.CrearBancoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class BancoDTO extends CrearBancoDTO {
    private UUID bancoId;
}