package com.saludsystem.catalogo.application.services;

import com.saludsystem.catalogo.application.dtos.res.PlanRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PlanService extends GenericService<
        com.saludsystem.catalogo.application.dtos.req.PlanRequest,
        PlanRequest,
        UUID> {
}