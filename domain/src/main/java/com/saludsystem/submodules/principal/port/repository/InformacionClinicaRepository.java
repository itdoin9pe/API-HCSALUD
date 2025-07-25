package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.InformacionClinica;

import java.util.UUID;

public interface InformacionClinicaRepository {
    InformacionClinica save(InformacionClinica informacionClinica);
    InformacionClinica update(UUID uuid, InformacionClinica informacionClinica);
    void delete(UUID uuid);
}