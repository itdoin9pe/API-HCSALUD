package com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion;

import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.CostoHospitalizacionRepository;

import java.util.UUID;

public class CostoHospitalizacionDeleteService {

    private final CostoHospitalizacionRepository costoHospitalizacionRepository;
    private final CostoHospitalizacionDao costoHospitalizacionDao;

    public CostoHospitalizacionDeleteService(CostoHospitalizacionRepository costoHospitalizacionRepository, CostoHospitalizacionDao costoHospitalizacionDao) {
        this.costoHospitalizacionRepository = costoHospitalizacionRepository;
        this.costoHospitalizacionDao = costoHospitalizacionDao;
    }

    public void execute(UUID uuid) {

        var costoHospitalizacion = costoHospitalizacionDao.getById(uuid);

        if (costoHospitalizacion.getTotalCosto() == null) {

            throw new IllegalStateException("El total de costo es nulo, no se puede eliminar");

        }

        costoHospitalizacionRepository.delete(uuid);

    }

}
