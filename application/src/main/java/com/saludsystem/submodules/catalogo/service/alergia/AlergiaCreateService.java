package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.Alergia;
import com.saludsystem.submodules.catalogo.model.dto.command.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;

public class AlergiaCreateService {

    private final AlergiaRepository alergiaRepository;

    public AlergiaCreateService(AlergiaRepository alergiaRepository) {
        this.alergiaRepository = alergiaRepository;
    }

    public Alergia execute(AlergiaCreateCommand alergiaCreateCommand) {
        var alergiaToCreate = AlergiaMapper.fromCreateDto(alergiaCreateCommand);
        return alergiaRepository.save(alergiaToCreate);
    }
}