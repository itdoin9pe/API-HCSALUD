package com.saludSystem.dtos.catalago;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PlanDTO {
    private UUID planId;
    private String nombrePlan;
    private Date fechaInicio;
    private Date fechaFin;
    private int maxPlan;
    private int useMax;
    private Double costoPlan;
    private Integer estado;
}
