package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;

import java.util.UUID;

@Data
public class ActualizarAnalisisOclusal1DTO {

    private UUID hospitalId;
    private UUID userId;
    private UUID pacienteAnalisisOclusal1Id;
    private UUID pacienteId;
    private String mandibula;
    private String transversal;
    private String derechoOclusal;
    private String izquierdoOclusal;
    private String verticalOclusal;
    private String mordidaOclusal;
    private String mmOclusal;
    private String curvaspeeoclusal;
    private String inferioresOclusal;
    private String incisivosOclusal;
    private String intrusionOclusal;
    private String molaresOclusal;
    private String molaresInstrusivosOclusal;
    private String sagitaloclusal;
    private String mm2Oclusal;
    private String caninoDerechoOclusal;
    private String caninoIzquierdoOclusal;

}