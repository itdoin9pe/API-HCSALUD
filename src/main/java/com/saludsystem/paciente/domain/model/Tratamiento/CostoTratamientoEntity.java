package com.saludsystem.paciente.domain.model.Tratamiento;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "pacientes_costos_tratamientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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