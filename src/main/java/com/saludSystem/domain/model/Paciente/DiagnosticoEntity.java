package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Mantenimiento.EnfermedadEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_diagnosticos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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