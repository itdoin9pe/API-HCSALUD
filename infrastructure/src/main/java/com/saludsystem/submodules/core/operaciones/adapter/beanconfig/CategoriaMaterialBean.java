package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;
import com.saludsystem.submodules.operaciones.service.categoria_material.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaMaterialBean {

    @Bean
    public CategoriaMaterialCreateService categoriaMaterialCreateService(CategoriaMaterialRepository repository) {
        return new CategoriaMaterialCreateService(repository);
    }

    @Bean
    public CategoriaMaterialEditService categoriaMaterialEditService(CategoriaMaterialRepository repository) {
        return new CategoriaMaterialEditService(repository);
    }

    @Bean
    public CategoriaMaterialDeleteService categoriaMaterialDeleteService(CategoriaMaterialRepository repository) {
        return new CategoriaMaterialDeleteService(repository);
    }

    @Bean
    public CategoriaMaterialListService categoriaMaterialListService(CategoriaMaterialDao dao) {
        return new CategoriaMaterialListService(dao);
    }

    @Bean
    public CategoriaMaterialByIdService categoriaMaterialByIdService(CategoriaMaterialDao dao) {
        return new CategoriaMaterialByIdService(dao);
    }

    @Bean
    public CategoriaMaterialAllService categoriaMaterialAllService(CategoriaMaterialDao dao) {
        return new CategoriaMaterialAllService(dao);
    }

}
