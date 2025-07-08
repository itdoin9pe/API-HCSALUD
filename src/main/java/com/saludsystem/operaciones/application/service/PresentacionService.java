package com.saludsystem.operaciones.application.service;

import com.saludsystem.operaciones.application.dto.res.PresentacionResponse;
import com.saludsystem.operaciones.application.dto.req.PresentacionRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface PresentacionService extends GenericService<
        PresentacionRequest,
        PresentacionResponse,
        UUID> {
}