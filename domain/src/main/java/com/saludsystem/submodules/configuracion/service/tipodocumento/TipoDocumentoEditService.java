package com.saludsystem.submodules.configuracion.service.tipodocumento;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.TipoDocumentoRepository;

import java.util.UUID;

public class TipoDocumentoEditService {

    private final TipoDocumentoDao tipoDocumentoDao;
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoEditService(TipoDocumentoDao tipoDocumentoDao, TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoDao = tipoDocumentoDao;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public TipoDocumento execute(UUID uuid, TipoDocumento tipoDocumento) {
        var currentTipoDoc = tipoDocumentoDao.getById(uuid);
        if (currentTipoDoc == null) {
            throw new IllegalArgumentException(TipoDocumentoConstant.ID_NOT_FOUND);
        }
        if (currentTipoDoc.getEstado() != null && currentTipoDoc.getEstado() == 0) {
            throw new IllegalStateException("El tipo de documento ya se encuentra desactivado");
        }
        currentTipoDoc.actualizarTipoComprobante(tipoDocumento.getTipoComprobante());
        currentTipoDoc.actualizarSerie(tipoDocumento.getSerie());
        currentTipoDoc.actualizarInicio(tipoDocumento.getInicio());
        currentTipoDoc.actualizarFin(tipoDocumento.getFin());
        currentTipoDoc.actualizarCorrelativoActual(tipoDocumento.getCorrelativoActual());
        currentTipoDoc.actualizarEstado(tipoDocumento.getEstado());
        return tipoDocumentoRepository.update(uuid, currentTipoDoc);
    }
}