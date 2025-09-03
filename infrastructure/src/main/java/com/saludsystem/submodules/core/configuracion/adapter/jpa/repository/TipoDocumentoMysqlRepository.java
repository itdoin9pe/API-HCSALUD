package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.constant.TipoDocumentoConstant;
import com.saludsystem.submodules.configuracion.port.in.repository.TipoDocumentoRepository;
import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.core.configuracion.adapter.entity.TipoDocumentoEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.TipoDocumentoJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.TipoDocumentoDboMapper;
import com.saludsystem.submodules.security.validators.ResourceNotFoundException;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoDocumentoMysqlRepository implements TipoDocumentoRepository {

    private final TipoDocumentoJpaRepository tipoDocumentoJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public TipoDocumentoMysqlRepository(TipoDocumentoJpaRepository tipoDocumentoJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.tipoDocumentoJpaRepository = tipoDocumentoJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public TipoDocumento save(TipoDocumento tipoDocumento) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
    	UUID userId = authenticateUserPort.getUserId();
        TipoDocumentoEntity entity = TipoDocumentoDboMapper.toEntity(tipoDocumento, hospitalId, userId);
        return TipoDocumentoDboMapper.toDomain(tipoDocumentoJpaRepository.save(entity));
    }

    @Override
    public TipoDocumento update(UUID uuid, TipoDocumento tipoDocumento) {
    	if (!tipoDocumentoJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(TipoDocumentoConstant.ID_NOT_FOUND);
		}
        UUID hospitalId = authenticateUserPort.getHospitalId();
    	UUID userId = authenticateUserPort.getUserId();
        TipoDocumentoEntity entity = TipoDocumentoDboMapper.toEntity(tipoDocumento, hospitalId, userId);
        entity.setTipoDocumentoId(uuid);
        return TipoDocumentoDboMapper.toDomain(tipoDocumentoJpaRepository.save(entity));
    }

    @Override
    public void delete(UUID uuid) {
    	if (!tipoDocumentoJpaRepository.existsById(uuid)) {
			throw new ResourceNotFoundException(TipoDocumentoConstant.ID_NOT_FOUND);
		}
        tipoDocumentoJpaRepository.deleteById(uuid);
    }
}
