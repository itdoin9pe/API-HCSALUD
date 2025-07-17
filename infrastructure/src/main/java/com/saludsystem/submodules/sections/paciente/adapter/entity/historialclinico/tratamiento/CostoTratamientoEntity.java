package com.saludsystem.submodules.sections.paciente.adapter.entity.historialclinico.tratamiento;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.paciente.adapter.entity.PacienteEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "pacientes_costos_tratamientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class CostoTratamientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_costo_tratamiento", nullable = false)
    private UUID pacienteCostoTratamientoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "id_plan_tratamiento", nullable = false)
    private PlanTratamientoEntity planTratamientoEntity;

    @Column(name = "concepto_costo_tratamiento", nullable = false)
    private String concepto;

    @Column(name = "monto_costo_tratamiento", nullable = false)
    private double monto;

    @Column(name = "moneda_costo_tratamiento", nullable = false)
    private String moneda;

    @Column(name = "pagado_costo_tratamiento", nullable = false)
    private boolean pagado;

}