package com.saludsystem.movimientos.application.service;

import com.saludsystem.movimientos.application.dto.res.AlmacenResponse;
import com.saludsystem.movimientos.application.dto.req.AlmacenRequest;
import com.saludsystem.shared.application.service.GenericService;

import java.util.UUID;

public interface AlmacenService extends GenericService<
        AlmacenRequest,
        AlmacenResponse,
        UUID> {
}