package com.saludsystem.paciente.domain.model.Evolucion;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_evoluciones_altas_medicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class AltaMedicaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alta_medica_id", nullable = false)
    private Long id;

    @Column(name = "alta_medida_fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "alta_medica_resument_final", nullable = false)
    private String resumenFinal;

    @OneToOne
    @JoinColumn(name = "paciente_evolucion_id")
    private EvolucionEntity evolucionEntity;

}