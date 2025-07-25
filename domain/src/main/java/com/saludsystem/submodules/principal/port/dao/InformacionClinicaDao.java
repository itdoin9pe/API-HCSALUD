package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.InformacionClinica;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface InformacionClinicaDao {
    InformacionClinica getById(UUID uuid);
    ListResponse<InformacionClinica> getAll(UUID hospitalId, int page, int rows);
    List<InformacionClinica> getList();
}