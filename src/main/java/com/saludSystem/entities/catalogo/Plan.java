package com.saludSystem.entities.catalogo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID planId;

    private String nombrePlan;

    private Date fechaInicio;

    private Date fechaFin;

    private int maxPlan;

    private int usuMax;

    private Double costoPlan;

    private Integer estado;

}
