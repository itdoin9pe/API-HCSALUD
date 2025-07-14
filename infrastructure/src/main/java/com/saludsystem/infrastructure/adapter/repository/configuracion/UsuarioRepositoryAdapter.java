package com.saludsystem.infrastructure.adapter.repository.configuracion;

import com.saludsystem.domain.configuracion.model.Usuario;
import com.saludsystem.domain.configuracion.port.out.repository.UsuarioRepositoryPort;
import com.saludsystem.infrastructure.adapter.jparepository.configuracion.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UserJpaRepository userJpaRepository;

    public UsuarioRepositoryAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public Usuario update(UUID uuid, Usuario usuario) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Usuario findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Usuario> findAll(UUID hospitalId, int page, int rows) {
        return List.of();
    }

    @Override
    public long countByHospitalId(UUID hospitalId) {
        return 0;
    }
}
