package com.saludSystem.domain.model.Paciente;

import com.saludSystem.domain.model.BaseEntity;
import com.saludSystem.domain.model.Catalogo.EspecialidadEntity;
import com.saludSystem.domain.model.Principal.DoctorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_analisis_general")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AnalisisGeneralEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_analisis_general_id", nullable = false)
    private UUID pacienteAnalisisGeneralId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private EspecialidadEntity especialidadEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private DoctorEntity doctorEntity;

    @Column(name = "tipo_ortodoncia", nullable = false)
    private String tipoOrtodoncia;

    @Column(name = "duracion_ortodoncia", nullable = false)
    private String duracionOrtodoncia;

    @Column(name = "fecha_inicio_ortodoncia", nullable = false)
    private LocalDate fechaInicioOrtodoncia;

    @Column(name = "fecha_fin_ortodoncia", nullable = false)
    private LocalDate fechaFinOrtodoncia;

    @Column(name = "anclaje_superior_ortodoncia", nullable = false)
    private String anclajeSuperiorOrtodoncia;

    @Column(name = "anclaje_inferior_ortodoncia", nullable = false)
    private String anclajeInferiorOrtodoncia;

    @Column(name = "nota_ortodoncia", nullable = false)
    private String notaOrtodoncia;

}