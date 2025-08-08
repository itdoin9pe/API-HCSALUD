package com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago;

import com.saludsystem.submodules.paciente.model.constant.estadocuenta.EPagoConstant;
import com.saludsystem.submodules.paciente.model.entity.estadocuenta.EPago;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EPagoRepository;

import java.util.UUID;

public class EPagoEditService {

    private final EPagoDao ePagoDao;
    private final EPagoRepository ePagoRepository;

    public EPagoEditService(EPagoDao ePagoDao, EPagoRepository ePagoRepository) {
        this.ePagoDao = ePagoDao;
        this.ePagoRepository = ePagoRepository;
    }

    public EPago execute(UUID uuid, EPago ePago) {

        var currentEpago = ePagoDao.getById(uuid);

        if (currentEpago == null) {

            throw new IllegalArgumentException(EPagoConstant.INVALID_ID);

        }

        if (currentEpago.getMetodoPago() != null && currentEpago.getMetodoPago().equals("EMPTY")) {

            throw new IllegalStateException("El metodo de pago no puede ser EMPTY");

        }

        return ePagoRepository.update(uuid, ePago);

    }

}
