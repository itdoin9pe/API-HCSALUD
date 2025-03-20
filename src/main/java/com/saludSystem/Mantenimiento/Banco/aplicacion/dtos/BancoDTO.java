package com.saludSystem.Mantenimiento.Banco.aplicacion.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class BancoDTO {

    private UUID bancoId;

    private String descripcion;

    private String estado;

}
