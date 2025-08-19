package com.saludsystem.submodules.movimiento.service.compra;

import com.saludsystem.submodules.movimiento.model.Compra;
import com.saludsystem.submodules.movimiento.model.constant.CompraConstant;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraRepository;

import java.util.UUID;

public class CompraEditService {

    private final CompraDao compraDao;
    private final CompraRepository compraRepository;

    public CompraEditService(CompraDao compraDao, CompraRepository compraRepository) {
        this.compraDao = compraDao;
        this.compraRepository = compraRepository;
    }

    public Compra execute(UUID uuid, Compra compra) {

        var currentCompra = compraDao.getById(uuid);

        if (currentCompra == null) {

            throw new IllegalArgumentException(CompraConstant.INVALID_ID);

        }

        if (currentCompra.getEstado() != null && currentCompra.getEstado() == 0) {

            throw new IllegalStateException("La compra ya se encuentra desactivada");

        }

        return compraRepository.update(uuid, compra);

    }

}
