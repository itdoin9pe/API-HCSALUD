package com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago;

import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EPagoRepository;

import java.util.UUID;

public class EPagoDeleteService {

    private final EPagoRepository ePagoRepository;
    private final EPagoDao ePagoDao;

    public EPagoDeleteService(EPagoRepository ePagoRepository, EPagoDao ePagoDao) {
        this.ePagoRepository = ePagoRepository;
        this.ePagoDao = ePagoDao;
    }

    public void execute(UUID uuid) {

        var ePago = ePagoDao.getById(uuid);

        if (ePago.getMonto() != null && ePago.getMonto() == 0) {

            throw new IllegalStateException("No se puede eliminar un estado de pago en 0");

        }

        ePagoRepository.delete(uuid);

    }

}
