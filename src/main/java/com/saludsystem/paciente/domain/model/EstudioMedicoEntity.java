package com.saludsystem.paciente.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.medico.domain.model.DoctorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_estudios_medicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EstudioMedicoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente_estudio", nullable = false)
    private Long id;

    @Column(name = "tipo_estudio", nullable = false)
    private String tipo;

    @Column(name = "descripcion_estudio", nullable = false)
    private String descripcion;

    private LocalDateTime requestAt;

    private LocalDateTime performedAt;

    @Column(name = "estado_estudio", nullable = false)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctorEntity;

    @OneToOne(mappedBy = "estudioMedicoEntity", cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente_estudio_resultado")
    private EstudioResultadoEntity estudioResultadoEntity;

}