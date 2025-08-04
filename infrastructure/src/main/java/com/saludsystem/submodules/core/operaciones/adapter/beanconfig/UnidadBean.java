package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.UnidadMapper;
import com.saludsystem.submodules.operaciones.port.dao.UnidadDao;
import com.saludsystem.submodules.operaciones.port.repository.UnidadRepository;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadCreateService;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadDeleteService;
import com.saludsystem.submodules.operaciones.service.unidad.UnidadEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnidadBean {

    @Bean
    public UnidadMapper unidadMapper() {
        return new UnidadMapper();
    }

    @Bean
    public UnidadCreateService unidadCreateService(UnidadRepository repository) {
        return new UnidadCreateService(repository);
    }

    @Bean
    public UnidadEditService unidadEditService(UnidadDao dao, UnidadRepository repository) {
        return new UnidadEditService(dao, repository);
    }

    @Bean
    public UnidadDeleteService unidadDeleteService(UnidadRepository repository, UnidadDao dao) {
        return new UnidadDeleteService(repository, dao);
    }

}
