package com.saludsystem.submodules.configuracion.service.user;

import com.saludsystem.submodules.configuracion.model.Usuario;
import com.saludsystem.submodules.configuracion.model.constant.UserConstant;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;

import java.util.UUID;

public class UserEditService {

    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserEditService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public Usuario execute(UUID uuid, Usuario usuario) {
        var currentUser = userDao.getById(uuid);
        if (currentUser == null) {
            throw new IllegalArgumentException(UserConstant.ID_NOT_FOUND);
        }
        currentUser.actualizarApellido(usuario.getLastName());
        currentUser.actualizarNombre(usuario.getFirstName());
        currentUser.actualizarEmail(usuario.getEmail());
        currentUser.actualizarUsername(usuario.getUsername());
        currentUser.actualizarPassword(usuario.getPassword());
        currentUser.actualizarAddress(usuario.getAddress());
        currentUser.actualizarTipoDocumento(usuario.getDocumentType());
        currentUser.actualizarNumeroDocumento(usuario.getDocumentNumber());
        currentUser.actualizarFoto(usuario.getPhoto());
        currentUser.actualizarRol(usuario.getRolId());
        currentUser.actualizarHospital(usuario.getHospitalId());
        currentUser.actualizarEstado(usuario.getEstado());
        return userRepository.update(uuid, usuario);
    }
}