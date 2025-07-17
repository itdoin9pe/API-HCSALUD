package com.saludsystem.submodules.sections.paciente.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.mantenimiento.adapter.entity.EnfermedadEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_diagnosticos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class DiagnosticoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_diagnosticos_id", nullable = false)
    private UUID pacienteDiagnosticoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "enfermedad_id", nullable = false)
    private EnfermedadEntity enfermedadEntity;

    @Column(name = "fecha_diagnostico", nullable = false)
    private LocalDate fecha;

    @Column(name = "descripcion_diagnostico", nullable = false)
    private String descripcion;

}