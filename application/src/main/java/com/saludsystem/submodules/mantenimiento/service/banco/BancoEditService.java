package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.Banco;
import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarBancoDTO;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;

import java.util.UUID;

public class BancoEditService {

    private final BancoRepository bancoRepository;

    public BancoEditService(BancoRepository bancoRepository) {
        this.bancoRepository = bancoRepository;
    }

    public Banco execute(UUID uuid, ActualizarBancoDTO dto) {

        var updateToSave = BancoMapper.fromUpdateDto(uuid, dto);

        return bancoRepository.update(uuid, updateToSave);

    }
}
