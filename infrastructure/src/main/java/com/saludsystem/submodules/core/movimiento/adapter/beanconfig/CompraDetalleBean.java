package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import com.saludsystem.submodules.movimiento.mapper.CompraDetalleMapper;
import com.saludsystem.submodules.movimiento.port.dao.CompraDetalleDao;
import com.saludsystem.submodules.movimiento.port.repository.CompraDetalleRepository;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleCreateService;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleDeleteService;
import com.saludsystem.submodules.movimiento.service.compradetalle.CompraDetalleEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompraDetalleBean {

    @Bean
    public CompraDetalleMapper compraDetalleMapper() {

        return new CompraDetalleMapper();

    }

    @Bean
    public CompraDetalleCreateService compraDetalleCreateService(CompraDetalleRepository repository) {

        return new CompraDetalleCreateService(repository);

    }

    @Bean
    public CompraDetalleEditService compraDetalleEditService(CompraDetalleDao dao, CompraDetalleRepository repository) {

        return new CompraDetalleEditService(dao, repository);

    }

    @Bean
    public CompraDetalleDeleteService compraDetalleDeleteService(
            CompraDetalleRepository repository, CompraDetalleDao dao) {

        return new CompraDetalleDeleteService(repository, dao);

    }

}
