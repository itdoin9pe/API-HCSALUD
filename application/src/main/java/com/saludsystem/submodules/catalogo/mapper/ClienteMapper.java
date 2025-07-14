package com.saludsystem.submodules.catalogo.mapper;

import com.saludsystem.submodules.catalogo.dtos.get.ClienteDTO;
import com.saludsystem.submodules.catalogo.dtos.post.CrearClienteDTO;
import com.saludsystem.submodules.catalogo.dtos.put.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.model.Cliente;

import java.util.UUID;

public class ClienteMapper {
    public static Cliente fromCreateDTO(CrearClienteDTO dto){
        return new Cliente(null, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(),
                dto.getContacto(), dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
    }

    public static Cliente fromUpdateDTO(UUID uuid, ActualizarClienteDTO dto){
        return new Cliente(uuid, dto.getTipoDocumento(), dto.getNombre(), dto.getDireccion(),
                dto.getContacto(), dto.getEmail(), dto.getTipoDocumento(), dto.getEstado());
    }

    public static ClienteDTO toDto(Cliente model){
        return new ClienteDTO(model.getId(), model.getTipoDocumento(), model.getNombre(),
                model.getDireccion(), model.getContacto(),
                model.getEmail(), model.getTipoDocumento(), model.getEstado());
    }
}
