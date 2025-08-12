package com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento;

import com.saludsystem.submodules.paciente.port.dao.tratamiento.CostoTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.CostoTratamientoRepository;

import java.util.UUID;

public class CostoTratamientoDeleteService {

    private final CostoTratamientoRepository costoTratamientoRepository;
    private final CostoTratamientoDao costoTratamientoDao;

    public CostoTratamientoDeleteService(CostoTratamientoRepository costoTratamientoRepository, CostoTratamientoDao costoTratamientoDao) {
        this.costoTratamientoRepository = costoTratamientoRepository;
        this.costoTratamientoDao = costoTratamientoDao;
    }

    public void execute(UUID uuid) {

        var costoTratamiento = costoTratamientoDao.getById(uuid);

        if (costoTratamiento.getMoneda() != null && costoTratamiento.getMonto() == 0) {

            throw new IllegalStateException("No se puede eliminar un costo de tratamiento sin monto asignado");

        }

        costoTratamientoRepository.delete(uuid);

    }

}
