package com.saludsystem.submodules.paciente.port.dao.interconsulta;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.InformeInterconsulta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface InformeInterconsultaDao {

    List<InformeInterconsulta> getList();
    InformeInterconsulta getById(UUID uuid);
    ListResponse<InformeInterconsulta> getAll(UUID hospitalId, int page, int rows);


}
