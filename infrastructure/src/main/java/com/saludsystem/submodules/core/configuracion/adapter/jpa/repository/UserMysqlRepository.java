package com.saludsystem.submodules.core.configuracion.adapter.jpa.repository;

import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import com.saludsystem.submodules.core.configuracion.adapter.entity.RoleEntity;
import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.RoleJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.jpa.UserJpaRepository;
import com.saludsystem.submodules.core.configuracion.adapter.mapper.UserDboMapper;
import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Transactional
public class UserMysqlRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    private final AuthenticateUserPort authenticateUserPort;

    public UserMysqlRepository(UserJpaRepository userJpaRepository, 
    		RoleJpaRepository roleJpaRepository, AuthenticateUserPort authenticateUserPort) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.authenticateUserPort = authenticateUserPort;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        if (hospitalId == null) {
            throw new RuntimeException("HospitalId no encontrado para el usuario autenticado");
        }
        UserEntity entity = UserDboMapper.toEntity(usuario, hospitalId);
        return UserDboMapper.toDomain(userJpaRepository.save(entity));
    }

    @Override
    public Usuario update(UUID uuid, Usuario usuario) {
        UUID hospitalId = authenticateUserPort.getHospitalId();
        // 1. Verificar existencia del usuario actual
        UserEntity actual = userJpaRepository.findById(usuario.getId().value())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Buscar entidades necesarias para relaciones
        RoleEntity rol = roleJpaRepository.findById(usuario.getRolId().value())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // 3. Convertir dominio a DBO actualizado
        UserEntity actualizado = UserDboMapper.toEntity(usuario, hospitalId);

        // 4. Mantener ID y cualquier otro dato que no cambie (si aplica)
        actualizado.setUserId(actual.getUserId());

        // 5. Guardar
        UserEntity saved = userJpaRepository.save(actualizado);

        // 6. Devolver dominio actualizado
        return UserDboMapper.toDomain(saved);
    }

    @Override
    public void delete(UUID uuid) {
        userJpaRepository.deleteById(uuid);
    }

}
