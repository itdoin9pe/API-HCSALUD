package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaCreateCommand;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * The type Alergia by id handler.
 */
@Component
public class AlergiaByIdHandler {

    private final AlergiaByIdService alergiaByIdService;

    /**
     * Instantiates a new Alergia by id handler.
     *
     * @param alergiaByIdService the alergia by id service
     */
    public AlergiaByIdHandler(AlergiaByIdService alergiaByIdService) {
        this.alergiaByIdService = alergiaByIdService;
    }

    /**
     * Execute alergia dto.
     *
     * @param id the id
     * @return the alergia dto
     */
    public AlergiaCreateCommand execute(UUID id) {
        return alergiaByIdService.execute(id);
    }
}