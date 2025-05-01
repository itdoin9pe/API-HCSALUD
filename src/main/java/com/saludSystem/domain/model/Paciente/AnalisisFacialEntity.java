package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes_analisis_faciales")
@Getter @Setter
public class AnalisisFacialEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_analisis_facial_id", nullable = false)
    private UUID pacienteAnalisisFacialId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Column(name = "tipo_facial", nullable = false)
    private String tipoFacial;

    @Column(name = "convexion", nullable = false)
    private String convexion;

    @Column(name = "tercios_faciales", nullable = false)
    private String terciosFaciales;

    @Column(name = "superior", nullable = false)
    private String superior;

    @Column(name = "inferior", nullable = false)
    private String inferior;

    @Column(name = "medio", nullable = false)
    private String medio;

    @Column(name = "selado_labial", nullable = false)
    private String seladoLabial;

    @Column(name = "relacion_labios", nullable = false)
    private String relacionLabios;

    @Column(name = "simetria_facial", nullable = false)
    private String simetriaFacial;

    @Column(name = "simetria_derecho", nullable = false)
    private String simetriaDerecho;

    @Column(name = "simetria_izquierdo", nullable = false)
    private String simetriaIzquierdo;

    @Column(name = "simetria_facial_apertura", nullable = false)
    private String simetriaFacialApertura;

    @Column(name = "simetria_apertura_derecho", nullable = false)
    private String simetriaAperturaDerecho;

    @Column(name = "simetria_apertura_izquierdo", nullable = false)
    private String simetriaAperturaIzquierdo;

    @Column(name = "angulo_maso_labial", nullable = false)
    private String anguloMasoLabial;

    @Column(name = "surco_mento_labial", nullable = false)
    private String surcoMentoLabial;

    @Column(name = "proyeccion_sigomatica", nullable = false)
    private String proyeccionSigomatica;

    @Column(name = "linea_menton", nullable = false)
    private String lineaMenton;

    @Column(name = "angulo_menton", nullable = false)
    private String anguloMenton;

    @Column(name = "patron1", nullable = false)
    private String patron1;

    @Column(name = "retrusion_mandibular", nullable = false)
    private String retrusionMandibular;

    @Column(name = "protusion_maxilar", nullable = false)
    private String protusionMaxilar;

    @Column(name = "patron3", nullable = false)
    private String patron3;

    @Column(name = "protusion_mandibular2", nullable = false)
    private String protusion2Mandibular;

    @Column(name = "retrusion_maxilar2", nullable = false)
    private String retrusion2Maxilar;

    @Column(name = "cara_corta", nullable = false)
    private String caraCorta;

}