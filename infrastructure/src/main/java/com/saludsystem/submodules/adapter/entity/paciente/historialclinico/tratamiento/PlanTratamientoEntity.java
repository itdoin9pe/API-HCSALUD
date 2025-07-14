package com.saludsystem.submodules.adapter.entity.paciente.historialclinico.tratamiento;

import com.saludsystem.submodules.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.submodules.adapter.entity.catalogo.MedidaEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.medico.DoctorEntity;
import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
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