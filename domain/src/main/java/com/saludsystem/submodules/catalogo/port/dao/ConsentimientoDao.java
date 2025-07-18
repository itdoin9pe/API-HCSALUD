package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Consentimiento;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ConsentimientoDao {
    Consentimiento getById(UUID uuid);
    ListResponse<Consentimiento> getAll(UUID hospitalId, int page, int rows);
    List<Consentimiento> getList();
}