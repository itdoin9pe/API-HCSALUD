package com.saludsystem.submodules.configuracion.query.getList;

import com.saludsystem.submodules.configuracion.dtos.get.UsuarioDTO;
import com.saludsystem.submodules.configuracion.service.UserListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioListHandler {

    private final UserListService userListService;

    public UsuarioListHandler(UserListService userListService) {
        this.userListService = userListService;
    }

    public List<UsuarioDTO> execute() {
        return userListService.execute();
    }

}
