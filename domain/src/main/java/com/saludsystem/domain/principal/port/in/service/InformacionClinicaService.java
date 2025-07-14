package com.saludsystem.domain.principal.port.in.service;

import com.saludsystem.domain.principal.model.InformacionClinica;

import java.util.List;
import java.util.UUID;

public interface InformacionClinicaService {
    InformacionClinica save(InformacionClinica informacionClinica);
    InformacionClinica update(UUID uuid, InformacionClinica informacionClinica);
    void delete(UUID uuid);
    InformacionClinica getById(UUID uuid);
    List<InformacionClinica> getAll(UUID hospitalId, int page, int rows);
}