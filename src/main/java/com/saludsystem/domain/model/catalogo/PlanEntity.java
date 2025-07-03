package com.saludsystem.domain.model.catalogo;

import com.saludsystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "planes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlanEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_plan", nullable = false, unique = true)
    private UUID planId;

    @Column(name = "nombre_plan", nullable = false, length = 100)
    private String nombrePlan;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin_contrato", nullable = false)
    private LocalDate fechaFinContrato;

    @Column(name = "max_plan", nullable = false)
    private int maxPlan;

    @Column(name = "usu_max", nullable = false)
    private int usuMax;

    @Column(name = "costo_plan", nullable = false)
    private Double costoPlan;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}