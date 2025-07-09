package com.saludsystem.catalogo.application.dtos.get;

import com.saludsystem.catalogo.application.dtos.post.CrearPlanDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = false)
public class PlanDTO extends CrearPlanDTO {
    private UUID planId;
}