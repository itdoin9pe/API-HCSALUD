package com.saludsystem.infrastructure.adapter.mapper.catalogo;

import com.saludsystem.domain.catalogo.model.Cliente;
import com.saludsystem.infrastructure.adapter.entity.catalogo.ClienteEntity;

public class ClienteDboMapper {
    public static ClienteEntity toEntity(Cliente model) {
        ClienteEntity e = new ClienteEntity();
        e.setNombre(model.getNombre());
        e.setContacto(model.getContacto());
        e.setEmail(model.getEmail());
        e.setDireccion(model.getDireccion());
        e.setTelefono(model.getTelefono());
        e.setTipoDocumento(model.getTipoDocumento());
        e.setEstado(model.getEstado());
        return e;
    }

    public static Cliente toDomain(ClienteEntity e) {
        return new Cliente(e.getClienteId(),e.getNombre(), e.getContacto(),
                e.getDireccion(), e.getTelefono(), e.getEmail(),
                e.getTipoDocumento(),e.getEstado());
    }
}