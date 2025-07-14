package com.saludsystem.application.mantenimiento.dtos.get;

import com.saludsystem.application.mantenimiento.dtos.post.CrearBancoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class BancoDTO extends CrearBancoDTO {
    private UUID bancoId;
}