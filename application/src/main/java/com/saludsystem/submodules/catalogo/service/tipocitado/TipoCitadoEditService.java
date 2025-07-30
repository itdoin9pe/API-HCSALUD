package com.saludsystem.submodules.catalogo.service.tipocitado;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.model.TipoCitado;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.TipoCitadoEditCommand;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;

import java.util.UUID;

public class TipoCitadoEditService {

    private final TipoCitadoRepository tipoCitadoRepository;

    public TipoCitadoEditService(TipoCitadoRepository tipoCitadoRepository) {
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    public TipoCitado execute(UUID uuid, TipoCitadoEditCommand dto) {

        var updateToSave = TipoCitadoMapper.fromUpdateDto(uuid, dto);

        return tipoCitadoRepository.update(uuid, updateToSave);

    }
}
