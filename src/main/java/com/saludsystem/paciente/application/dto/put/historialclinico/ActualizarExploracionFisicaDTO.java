package com.saludsystem.paciente.application.dto.put.historialclinico;

import com.saludsystem.shared.application.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarExploracionFisicaDTO extends BaseDTO {
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
