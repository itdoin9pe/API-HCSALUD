package com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.tratamiento;

import com.saludsystem.domain.model.DoctorEntity;
import com.saludsystem.domain.model.EspecialidadEntity;
import com.saludsystem.domain.model.MedidaEntity;
import com.saludsystem.domain.model.PacienteEntity;
import com.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_plan_tratamientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class PlanTratamientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_plan_tratamiento")
    private UUID pacientePlanTratamientoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctorEntity;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadEntity especialidadEntity;

    @ManyToOne
    @JoinColumn(name = "id_medida", nullable = false)
    private MedidaEntity medidaEntity;

    @Column(name = "tratamienti_fecha_Inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "tratamienti_fecha_fin", nullable = false)
    private LocalDate fechaFin;

}