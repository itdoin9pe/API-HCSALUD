package com.saludsystem.paciente.domain.model.Evolucion;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_evoluciones_cambios_condiciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class CambioCondicionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cambio_condicion_id")
    private Long id;

    @Column(name = "fecha_cambio_condicion")
    private LocalDateTime fecha;

    @Column(name = "descripcion_cambio_condicion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "paciente_evolucion_id")
    private EvolucionEntity evolucionEntity;

}