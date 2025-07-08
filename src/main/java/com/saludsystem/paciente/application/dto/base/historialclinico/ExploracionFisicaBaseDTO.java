package com.saludsystem.paciente.application.dto.base.historialclinico;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class ExploracionFisicaBaseDTO {
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
