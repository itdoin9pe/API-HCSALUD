package com.saludsystem.submodules.core.paciente.adapter.entity.historialclinico.evolucion;

import com.saludsystem.submodules.core.configuracion.adapter.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes_evoluciones_notas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class NotaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evolucion_nota_id")
    private Long id;

    @Column(name = "fecha_nota", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "tipo_nota", nullable = false)
    private String tipo; // "medico" o "enfermeria"

    @Column(name = "contenido_nota", nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "paciente_evolucion_id")
    private EvolucionEntity evolucionEntity;

}