package com.saludsystem.cita.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;

import com.saludsystem.catalogo.domain.model.EspecialidadEntity;
import com.saludsystem.catalogo.domain.model.TipoCitadoEntity;
import com.saludsystem.configuracion.domain.model.SedeEntity;
import com.saludsystem.medico.domain.model.DoctorEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "citas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class CitaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_cita", nullable = false)
    private UUID citadoId;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadEntity especialidadEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctorEntity;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private SedeEntity sedeEntity;

    @ManyToOne
    @JoinColumn(name = "tipoCitadoId", nullable = false)
    private TipoCitadoEntity tipoCitadoEntity;

    @Column(name = "estado_cita", nullable = false)
    private String estado;

    @Column(name = "motivoConsulta_cita", nullable = false)
    private String motivoConsulta;

    @Column(name = "observacion_cita", nullable = false)
    private String observacion;
}