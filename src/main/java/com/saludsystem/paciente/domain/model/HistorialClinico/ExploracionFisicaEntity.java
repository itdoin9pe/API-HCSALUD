package com.saludsystem.paciente.domain.model.HistorialClinico;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pacientes_exploracion_fisica")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ExploracionFisicaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_exploracion_fisica_id", nullable = false)
    private UUID pacienteExploracionId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @Column(name = "paciente_presion_arterial", nullable = false)
    private String presionArterial;

    @Column(name = "paciente_pulso", nullable = false)
    private String pulso;

    @Column(name = "paciente_temperatura", nullable = false)
    private String temperatura;

    @Column(name = "paciente_frecuencia_cardiaca", nullable = false)
    private String frecuenciaCardiaca;

    @Column(name = "paciente_frecuencia_respiratoria", nullable = false)
    private String frecuenciaRespiratoria;

    @Column(name = "paciente_peso", nullable = false)
    private String peso;

    @Column(name = "paciente_talla", nullable = false)
    private String talla;

    @Column(name = "paciente_masa", nullable = false)
    private String masa;

    @Column(name = "paciente_examen_clinico", nullable = false)
    private String examenClinico;

    @Column(name = "paciente_complemento_examen", nullable = false)
    private String complementoExamen;

}