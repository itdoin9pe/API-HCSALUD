package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaCreateService;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaDeleteService;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CajaBean {

    @Bean
    public CajaMapper cajaMapper() {
        return new CajaMapper();
    }

    @Bean
    public CajaCreateService cajaCreateService(CajaRepository repository) {
        return new CajaCreateService(repository);
    }

    @Bean
    public CajaEditService cajaEditService(CajaDao dao, CajaRepository repository) {
        return new CajaEditService(dao, repository);
    }

    @Bean
    public CajaDeleteService cajaDeleteService(CajaRepository repository, CajaDao dao) {
        return new CajaDeleteService(repository, dao);
    }

}
