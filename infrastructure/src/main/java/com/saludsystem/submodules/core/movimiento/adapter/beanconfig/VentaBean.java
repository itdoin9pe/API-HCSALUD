package com.saludsystem.submodules.core.movimiento.adapter.beanconfig;

import com.saludsystem.submodules.movimiento.mapper.VentaMapper;
import com.saludsystem.submodules.movimiento.port.dao.VentaDao;
import com.saludsystem.submodules.movimiento.port.repository.VentaRepository;
import com.saludsystem.submodules.movimiento.service.venta.VentaCreateService;
import com.saludsystem.submodules.movimiento.service.venta.VentaDeleteService;
import com.saludsystem.submodules.movimiento.service.venta.VentaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentaBean {

    @Bean
    public VentaMapper ventaMapper() {

        return new VentaMapper();

    }

    @Bean
    public VentaCreateService ventaCreateService(VentaRepository repository) {

        return new VentaCreateService(repository);

    }

    @Bean
    public VentaEditService ventaEditService(VentaDao dao, VentaRepository repository) {

        return new VentaEditService(dao, repository);

    }

    @Bean
    public VentaDeleteService ventaDeleteService(VentaRepository repository, VentaDao dao) {

        return new VentaDeleteService(repository, dao);

    }

}
