package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import com.saludsystem.submodules.movimiento.mapper.InventarioMapper;
import com.saludsystem.submodules.movimiento.port.dao.InventarioDao;
import com.saludsystem.submodules.movimiento.port.repository.InventarioRepository;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioCreateService;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioDeleteService;
import com.saludsystem.submodules.movimiento.service.inventario.InventarioEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventarioBean {

    @Bean
    public InventarioMapper inventarioMapper() {

        return new InventarioMapper();

    }

    @Bean
    public InventarioCreateService inventarioCreateService(InventarioRepository repository) {

        return new InventarioCreateService(repository);

    }

    @Bean
    public InventarioEditService inventarioEditService(InventarioDao dao, InventarioRepository repository) {

        return new InventarioEditService(dao, repository);

    }

    @Bean
    public InventarioDeleteService inventarioDeleteService(InventarioRepository repository, InventarioDao dao) {

        return new InventarioDeleteService(repository, dao);

    }

}
