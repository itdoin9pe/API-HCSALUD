package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;
import com.saludsystem.submodules.catalogo.service.categoria.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaBean {

    @Bean
    public CategoriaCreateService createService(CategoriaRepository repository) {
        return new CategoriaCreateService(repository);
    }

    @Bean
    public CategoriaEditService editService(CategoriaRepository repository) {
        return new CategoriaEditService(repository);
    }

    @Bean
    public CategoriaDeleteService deleteService(CategoriaRepository repository) {
        return new CategoriaDeleteService(repository);
    }

    @Bean
    public CategoriaByIdService byIdService(CategoriaDao dao) {
        return new CategoriaByIdService(dao);
    }

    @Bean
    public CategoriaAllService allService(CategoriaDao dao) {
        return new CategoriaAllService(dao);
    }

    @Bean
    public CategoriaListService listService(CategoriaDao dao) {
        return new CategoriaListService(dao);
    }
}
