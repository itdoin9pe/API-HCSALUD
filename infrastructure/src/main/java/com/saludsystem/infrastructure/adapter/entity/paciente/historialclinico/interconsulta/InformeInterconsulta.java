package com.saludsystem.infrastructure.adapter.entity.paciente.historialclinico.interconsulta;

import com.saludsystem.infrastructure.adapter.entity.configuracion.BaseEntity;
import com.saludsystem.infrastructure.adapter.entity.medico.DoctorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "pacientes_interconsultas_informes")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InformeInterconsulta extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_informe_interconsulta", nullable = false)
    private UUID pacienteInformeInterconsultaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_interconsulta", nullable = false)
    private InterconsultaEntity interconsultaEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity medicoResponsable;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String resumenClinico;

    @Column(columnDefinition = "TEXT")
    private String diagnostico;

    @Column(columnDefinition = "TEXT")
    private String recomendaciones;

    private String archivoAdjuntoUrl;

}