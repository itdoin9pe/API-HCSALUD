package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarExploracionFisicaDTO {

    private UUID hospitalId;
    private UUID userId;
    private UUID pacienteExploracionId;
    private UUID pacienteId;
    private String presionArterial;
    private String pulso;
    private String temperatura;
    private String frecuenciaCardiaca;
    private String frecuenciaRespiratoria;
    private String peso;
    private String talla;
    private String masa;
    private String examenClinico;
    private String complementoExamen;

}