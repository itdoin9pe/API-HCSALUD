package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;
import com.saludsystem.submodules.configuracion.port.in.repository.SedeRepository;
import com.saludsystem.submodules.configuracion.service.sede.SedeCreateService;
import com.saludsystem.submodules.configuracion.service.sede.SedeDeleteService;
import com.saludsystem.submodules.configuracion.service.sede.SedeEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SedeBean {

    @Bean
    public SedeMapper sedeMapper() {
        return new SedeMapper();
    }

    @Bean
    public SedeCreateService sedeCreateService(SedeRepository repository) {
        return new SedeCreateService(repository);
    }

    @Bean
    public SedeEditService sedeEditService(SedeDao dao, SedeRepository repository) {
        return new SedeEditService(dao, repository);
    }

    @Bean
    public SedeDeleteService sedeDeleteService(SedeRepository repository, SedeDao dao) {
        return new SedeDeleteService(repository, dao);
    }

}
