package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.catalogo.port.repository.CategoriaRepository;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaCreateService;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaDeleteService;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaBean {

    @Bean
    public CategoriaMapper categoriaMapper() {
        return new CategoriaMapper();
    }

    @Bean
    public CategoriaCreateService categoriaCreateService(CategoriaRepository repository) {
        return new CategoriaCreateService(repository);
    }

    @Bean
    public CategoriaEditService categoriaEditService(CategoriaDao dao, CategoriaRepository repository) {
        return new CategoriaEditService(dao, repository);
    }

    @Bean
    public CategoriaDeleteService categoriaDeleteService(CategoriaRepository repository, CategoriaDao dao) {
        return new CategoriaDeleteService(repository, dao);
    }

}
