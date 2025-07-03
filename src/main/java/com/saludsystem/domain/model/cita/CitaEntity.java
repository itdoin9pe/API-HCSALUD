package com.saludsystem.domain.model.cita;

import com.saludsystem.domain.model.BaseEntity;

import com.saludsystem.domain.model.catalogo.EspecialidadEntity;
import com.saludsystem.domain.model.catalogo.TipoCitadoEntity;
import com.saludsystem.domain.model.configuracion.SedeEntity;
import com.saludsystem.domain.model.medico.DoctorEntity;
import com.saludsystem.domain.model.paciente.PacienteEntity;
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
    private String Estado;

    @Column(name = "motivoConsulta_cita", nullable = false)
    private String motivoConsulta;

    @Column(name = "observacion_cita", nullable = false)
    private String observacion;
}