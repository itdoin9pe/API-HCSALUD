package com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio;

import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.DetalleMedicamentoEstudioRepository;

import java.util.UUID;

public class DetalleMedicamentoEstudioDeleteService {

    private final DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository;
    private final DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao;

    public DetalleMedicamentoEstudioDeleteService(DetalleMedicamentoEstudioRepository detalleMedicamentoEstudioRepository, DetalleMedicamentoEstudioDao detalleMedicamentoEstudioDao) {
        this.detalleMedicamentoEstudioRepository = detalleMedicamentoEstudioRepository;
        this.detalleMedicamentoEstudioDao = detalleMedicamentoEstudioDao;
    }

    public void execute(UUID uuid) {

        var detalleMedicEstudio = detalleMedicamentoEstudioDao.getById(uuid);

        if (detalleMedicEstudio.getDescripcion() != null && detalleMedicEstudio.getDescripcion().equals("EMPTY")) {

            throw new IllegalStateException("No se puede eliminar un detalle sin descripcion");

        }

        detalleMedicamentoEstudioRepository.delete(uuid);

    }

}
