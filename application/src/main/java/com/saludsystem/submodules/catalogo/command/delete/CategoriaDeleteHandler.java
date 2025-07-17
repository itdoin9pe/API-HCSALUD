package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaDeleteHandler {

    private final CategoriaDao categoriaDao;

    public CategoriaDeleteHandler(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public void execute(UUID uuid){
        categoriaDao.delete(uuid);
    }
}