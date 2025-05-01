package com.saludSystem.application.dtos.Paciente.PUT;

import lombok.Data;
import java.util.UUID;

@Data
public class ActualizarAnalisisFacialDTO {

    private UUID pacienteId;
    private String tipoFacial;
    private String convexion;
    private String terciosFaciales;
    private String superior;
    private String inferior;
    private String medio;
    private String seladoLabial;
    private String relacionLabios;
    private String simetriaFacial;
    private String simetriaDerecho;
    private String simetriaIzquierdo;
    private String simetriaFacialApertura;
    private String simetriaAperturaDerecho;
    private String simetriaAperturaIzquierdo;
    private String anguloMasoLabial;
    private String surcoMentoLabial;
    private String proyeccionSigomatica;
    private String lineaMenton;
    private String anguloMenton;
    private String patron1;
    private String retrusionMandibular;
    private String protusionMaxilar;
    private String patron3;
    private String protusion2Mandibular;
    private String retrusion2Maxilar;
    private String caraCorta;

}