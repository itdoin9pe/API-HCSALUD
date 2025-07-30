package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.model.Cliente;

import java.util.UUID;

public class ClienteMapper {
    public static Cliente fromCreateDTO(ClienteCreateCommand dto){
        return new Cliente(null, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(),
                dto.getContacto(), dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
    }

    public static Cliente fromUpdateDTO(UUID uuid, ActualizarClienteDTO dto){
        return new Cliente(uuid, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(),
                dto.getContacto(), dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
    }

    public static ClienteCreateCommand toDto(Cliente model){
        return new ClienteCreateCommand(model.getId(), model.getTipoDocumento(), model.getNombre(),
                model.getDireccion(), model.getContacto(),
                model.getEmail(), model.getTipoDocumento(), model.getEstado());
    }
}
