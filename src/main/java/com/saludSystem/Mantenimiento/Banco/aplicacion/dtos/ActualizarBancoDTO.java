package com.saludSystem.Mantenimiento.Banco.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarBancoDTO {

    private UUID hospitalId;

    private UUID userId;

    private UUID bancoId;

    private String descripcion;

    private Integer estado;

}
