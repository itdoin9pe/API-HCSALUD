package com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.evolucion;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.paciente.adapter.entity.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pacientes_evoluciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class EvolucionEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_evolucion_id", nullable = false)
    private UUID pacienteEvolucionId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    private Boolean finalizada = false;

    @OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private List<NotaEntity> notas;

    @OneToMany(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private List<CambioCondicionEntity> cambios;

    @OneToOne(mappedBy = "evolucionEntity", cascade = CascadeType.ALL)
    private AltaMedicaEntity altaMedica;

}