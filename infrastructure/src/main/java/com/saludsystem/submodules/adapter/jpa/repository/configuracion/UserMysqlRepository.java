package com.saludsystem.submodules.adapter.jpa.repository.configuracion;

import com.saludsystem.submodules.adapter.entity.configuracion.RoleEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.SysSaludEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.UserEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.RoleJpaRepository;
import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.SysSaludJpaRepository;
import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.UserJpaRepository;
import com.saludsystem.submodules.adapter.mapper.configuracion.UserDboMapper;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.out.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public class UserMysqlRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final RoleJpaRepository roleJpaRepository;
    private final SysSaludJpaRepository sysSaludJpaRepository;
    private final UserDboMapper userDboMapper;

    public UserMysqlRepository(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, SysSaludJpaRepository sysSaludJpaRepository, UserDboMapper userDboMapper) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.sysSaludJpaRepository = sysSaludJpaRepository;
        this.userDboMapper = userDboMapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        var userToSave = userDboMapper.toDboForCreate(usuario);
        var userSaved = userJpaRepository.save(userToSave);
        return userDboMapper.toDomain(userSaved);
    }

    @Override
    public Usuario update(Usuario usuario) {
        // 1. Verificar existencia del usuario actual
        UserEntity actual = userJpaRepository.findById(usuario.getId().value())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 2. Buscar entidades necesarias para relaciones
        RoleEntity rol = roleJpaRepository.findById(usuario.getRolId().value())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        SysSaludEntity hospital = sysSaludJpaRepository.findById(usuario.getHospitalId().value())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));

        // 3. Convertir dominio a DBO actualizado
        UserEntity actualizado = userDboMapper.toDbo(usuario, rol, hospital);

        // 4. Mantener ID y cualquier otro dato que no cambie (si aplica)
        actualizado.setUserId(actual.getUserId());

        // 5. Guardar
        UserEntity saved = userJpaRepository.save(actualizado);

        // 6. Devolver dominio actualizado
        return userDboMapper.toDomain(saved);
    }

    @Override
    public void delete(UUID uuid) {
        userJpaRepository.deleteById(uuid);
    }
}
