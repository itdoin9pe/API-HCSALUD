package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.CajaRepository;
import com.saludsystem.submodules.mantenimiento.service.caja.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CajaBean {

    @Bean
    public CajaCreateService cajaCreateService(CajaRepository repository) {
        return new CajaCreateService(repository);
    }

    @Bean
    public CajaEditService cajaEditService(CajaRepository repository) {
        return new CajaEditService(repository);
    }

    @Bean
    public CajaDeleteService cajaDeleteService(CajaRepository repository) {
        return new CajaDeleteService(repository);
    }

    @Bean
    public CajaByIdService cajaByIdService(CajaDao dao) {
        return new CajaByIdService(dao);
    }

    @Bean
    public CajaListService cajaListService(CajaDao dao) {
        return new CajaListService(dao);
    }

    @Bean
    public CajaAllService cajaAllService(CajaDao dao) {
        return new CajaAllService(dao);
    }

}
