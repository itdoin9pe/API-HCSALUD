package com.saludsystem.submodules.configuracion.port.in.service.user;

import com.saludsystem.submodules.configuracion.model.dto.command.UserEditCommand;
import com.saludsystem.submodules.configuracion.model.entity.Usuario;
import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.out.repository.UserRepository;

import java.util.UUID;

public class UserEditService {
    private final UserDao userDao;
    private final UserRepository userRepository;

    public UserEditService(UserDao userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public Usuario execute(UserEditCommand userEditCommand, UUID id) {
        var currentUser = userDao.getById(id);
        var updateUser = new Usuario(
                currentUser.getId().value(),
                userEditCommand.getFirstName(),
                userEditCommand.getLastName(),
                userEditCommand.getEmail(),
                userEditCommand.getUsername(),
                userEditCommand.getPassword(),
                userEditCommand.getPhoneNumber(),
                userEditCommand.getAddress(),
                userEditCommand.getDocumentType(),
                userEditCommand.getDocumentNumber(),
                userEditCommand.getPhoto(),
                userEditCommand.getEstado(),
                userEditCommand.getRolId(),
                userEditCommand.getHospitalId());
        return userRepository.update(updateUser);
    }
}
