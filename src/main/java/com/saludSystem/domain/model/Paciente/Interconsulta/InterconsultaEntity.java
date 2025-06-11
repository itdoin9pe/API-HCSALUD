package com.saludSystem.domain.model.Paciente.Interconsulta;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.EspecialidadEntity;
import com.saludSystem.domain.model.Medico.DoctorEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pacientes_interconsultas")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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