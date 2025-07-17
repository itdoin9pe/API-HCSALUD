package com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.dtos.TipoProcedimiento;
import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.medico.adapter.entity.DoctorEntity;
import com.saludsystem.submodules.sections.paciente.adapter.entity.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_procedimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class ProcedimientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_procedimiento_tratamiento")
    private UUID procedimientoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctorEntity;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_prodedimiento", nullable = false)
    private TipoProcedimiento tipoProcedimiento;

    @Column(name = "descripcion_procedimiento", nullable = false)
    private String descripcion;

    @Column(name = "fecha_procedimiento", nullable = false)
    private LocalDate fecha;

    @Column(name = "resultado_procedimiento", nullable = false)
    private String resultado;

}