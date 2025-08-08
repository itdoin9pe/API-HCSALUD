package com.saludsystem.submodules.configuracion.mapper;

import com.saludsystem.submodules.configuracion.model.TipoDocumento;
import com.saludsystem.submodules.configuracion.model.dtos.TipoDocumentoDTO;
import com.saludsystem.submodules.configuracion.model.dtos.command.TipoDocumentoCreateCommand;
import com.saludsystem.submodules.configuracion.model.dtos.command.edit.TipoDocumentoEditCommand;

import java.util.UUID;

public class TipoDocumentoMapper {

    public TipoDocumento fromCreateDto(TipoDocumentoCreateCommand createCommand) {

        return new TipoDocumento(null, createCommand.getTipoComprobante(), createCommand.getSerie(),
                createCommand.getInicio(), createCommand.getFin(), createCommand.getCorrelativoActual(),
                createCommand.getEstado());

    }

    public TipoDocumento fromUpdateDto(UUID uuid, TipoDocumentoEditCommand editCommand) {

        return new TipoDocumento(uuid, editCommand.getTipoComprobante(), editCommand.getSerie(),
                editCommand.getInicio(), editCommand.getFin(), editCommand.getCorrelativoActual(),
                editCommand.getEstado());

    }

    public TipoDocumentoDTO toDto(TipoDocumento model) {

        return new TipoDocumentoDTO(
                model.getId(),
                model.getTipoComprobante(),
                model.getSerie(),
                model.getInicio(),
                model.getFin(),
                model.getCorrelativoActual(),
                model.getEstado());


    }

}
