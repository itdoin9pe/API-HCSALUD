package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "paciente_analisis_oclusal1")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AnalisisOclusal1Entity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_analisis_oclusal_id", nullable = false)
    private UUID pacienteAnalisisOclusal1Id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteEntity pacienteEntity;

    @Column(name = "mandibula_paciente", nullable = false)
    private String mandibula;

    @Column(name = "transversal_paciente", nullable = false)
    private String transversal;

    @Column(name = "derechoOclusal_paciente", nullable = false)
    private String derechoOclusal;

    @Column(name = "izquierdoOclusal_paciente", nullable = false)
    private String izquierdoOclusal;

    @Column(name = "verticalOclusal_paciente", nullable = false)
    private String verticalOclusal;

    @Column(name = "mordidaOclusal_paciente", nullable = false)
    private String mordidaOclusal;

    @Column(name = "mmOclusal_paciente", nullable = false)
    private String mmOclusal;

    @Column(name = "curvaspeeoclusal_paciente", nullable = false)
    private String curvaspeeoclusal;

    @Column(name = "inferioresOclusal_paciente", nullable = false)
    private String inferioresOclusal;

    @Column(name = "incisivosOclusal_paciente", nullable = false)
    private String incisivosOclusal;

    @Column(name = "intrusionOclusal_paciente", nullable = false)
    private String intrusionOclusal;

    @Column(name = "molaresOclusal_paciente", nullable = false)
    private String molaresOclusal;

    @Column(name = "molaresInstrusivosOclusal_paciente", nullable = false)
    private String molaresInstrusivosOclusal;

    @Column(name = "sagitaloclusal_paciente", nullable = false)
    private String sagitaloclusal;

    @Column(name = "mm2Oclusal_paciente", nullable = false)
    private String mm2Oclusal;

    @Column(name = "caninoDerechoOclusal_paciente", nullable = false)
    private String caninoDerechoOclusal;

    @Column(name = "caninoIzquierdoOclusal_paciente", nullable = false)
    private String caninoIzquierdoOclusal;

}