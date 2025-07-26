package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.principal.port.repository.PaisRepository;
import com.saludsystem.submodules.principal.service.pais.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaisBean {

    @Bean
    public PaisCreateService paisCreateService(PaisRepository paisRepository) {
        return new PaisCreateService(paisRepository);
    }

    @Bean
    public PaisEditService paisEditService(PaisRepository paisRepository) {
        return new PaisEditService(paisRepository);
    }

    @Bean
    public PaisDeleteService paisDeleteService(PaisRepository paisRepository) {
        return new PaisDeleteService(paisRepository);
    }

    @Bean
    public PaisListService paisListService(PaisDao paisDao) {
        return new PaisListService(paisDao);
    }

    @Bean
    public PaisByIdService paisByIdService(PaisDao paisDao) {
        return new PaisByIdService(paisDao);
    }

    @Bean
    public PaisAllService paisAllService(PaisDao paisDao) {
        return new PaisAllService(paisDao);
    }

}
