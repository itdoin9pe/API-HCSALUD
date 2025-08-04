package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;
import com.saludsystem.submodules.principal.service.pais.PaisCreateService;
import com.saludsystem.submodules.principal.service.pais.PaisDeleteService;
import com.saludsystem.submodules.principal.service.pais.PaisEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaisBean {

    @Bean
    public PaisMapper paisMapper() {
        return new PaisMapper();
    }

    @Bean
    public PaisCreateService paisCreateService(PaisRepository paisRepository) {
        return new PaisCreateService(paisRepository);
    }

    @Bean
    public PaisEditService paisEditService(PaisDao paisDao, PaisRepository paisRepository) {
        return new PaisEditService(paisDao, paisRepository);
    }

    @Bean
    public PaisDeleteService paisDeleteService(PaisRepository paisRepository, PaisDao paisDao) {
        return new PaisDeleteService(paisRepository, paisDao);
    }

}
