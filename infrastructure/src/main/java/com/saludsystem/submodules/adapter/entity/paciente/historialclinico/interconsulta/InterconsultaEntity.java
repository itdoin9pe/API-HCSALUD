package com.saludsystem.submodules.adapter.entity.paciente.historialclinico.interconsulta;

import com.saludsystem.submodules.adapter.entity.catalogo.EspecialidadEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.submodules.adapter.entity.medico.DoctorEntity;
import com.saludsystem.submodules.adapter.entity.paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pacientes_interconsultas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterconsultaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_interconsulta", nullable = false)
    private UUID pacienteInterconsultaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity medicoSolicitante; // medico solicitante y destino

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadEntity especialidadDestino;

    @Column(nullable = false, length = 500)
    private String motivo;

    @Column(nullable = false)
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoInterconsulta estado;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrioridadInterconsulta prioridad;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    private LocalDateTime fechaAtencion;

}