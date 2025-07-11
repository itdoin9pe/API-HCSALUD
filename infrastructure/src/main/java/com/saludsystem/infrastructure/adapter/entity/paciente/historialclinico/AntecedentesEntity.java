package com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico;

import com.saludsystem.domain.model.PacienteEntity;
import com.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pacientes_enfermedades_actuales")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class AntecedentesEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID pacienteEnfermedadActualId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Column(name = "motivo_consulta", nullable = false)
    private String motivo;

    @Column(name = "enfermedad_actual", nullable = false)
    private String enfermedad;

    @Column(name = "tiempo_enfermedad", nullable = false)
    private String tiempoEnfermedad;

    @Column(name = "signo_sintomas_principales", nullable = false)
    private String signo;

    @Column(name = "relato_cronologico", nullable = false)
    private String relato;

    @Column(name = "funciones_biologicas", nullable = false)
    private String funciones;

    @Column(name = "antecedentes_personales", nullable = false)
    private String antecedentesPersonales;

    @Column(name = "antecedentes_familiares", nullable = false)
    private String antecedentesFamiliares;

    @Column(name = "medicamente_existente", nullable = false)
    private String medicamento;

    @Column(name = "nombre_medicamente", nullable = false)
    private String nombreMedicamento;

    @Column(name = "motivo_uso", nullable = false)
    private String motivoMedicamento;

    @Column(name = "dosis", nullable = false)
    private String dosis;

}