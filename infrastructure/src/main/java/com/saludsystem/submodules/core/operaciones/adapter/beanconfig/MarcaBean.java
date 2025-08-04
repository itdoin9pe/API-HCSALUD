package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;
import com.saludsystem.submodules.operaciones.service.marca.MarcaCreateService;
import com.saludsystem.submodules.operaciones.service.marca.MarcaDeleteService;
import com.saludsystem.submodules.operaciones.service.marca.MarcaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarcaBean {

    @Bean
    public MarcaMapper marcaMapper() {
        return new MarcaMapper();
    }

    @Bean
    public MarcaCreateService marcaCreateService(MarcaRepository repository) {
        return new MarcaCreateService(repository);
    }

    @Bean
    public MarcaEditService marcaEditService(MarcaDao dao, MarcaRepository repository) {
        return new MarcaEditService(dao, repository);
    }

    @Bean
    public MarcaDeleteService marcaDeleteService(MarcaRepository repository, MarcaDao dao) {
        return new MarcaDeleteService(repository, dao);
    }

}
