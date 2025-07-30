package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.operaciones.port.repository.MarcaRepository;
import com.saludsystem.submodules.operaciones.service.marca.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MarcaBean {

    @Bean
    public MarcaCreateService marcaCreateService(MarcaRepository repository) {
        return new MarcaCreateService(repository);
    }

    @Bean
    public MarcaEditService marcaEditService(MarcaRepository repository) {
        return new MarcaEditService(repository);
    }

    @Bean
    public MarcaDeleteService marcaDeleteService(MarcaRepository repository) {
        return new MarcaDeleteService(repository);
    }

    @Bean
    public MarcaAllService marcaAllService(MarcaDao dao) {
        return new MarcaAllService(dao);
    }

    @Bean
    public MarcaListService marcaListService(MarcaDao dao) {
        return new MarcaListService(dao);
    }

    @Bean
    public MarcaByIdService marcaByIdService(MarcaDao dao) {
        return new MarcaByIdService(dao);
    }

}
