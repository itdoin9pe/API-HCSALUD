package com.saludSystem.entities.catalogo;

import com.saludSystem.entities.BaseEntity;
import com.saludSystem.entities.configuracion.SysSalud;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planes")
public class Plan extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_plan", nullable = false, unique = true)
    private UUID planId;

    private String nombrePlan;

    private Date fechaInicio;

    private Date fechaFin;

    private int maxPlan;

    private int usuMax;

    private Double costoPlan;

    private Integer estado;

}