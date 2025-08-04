package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.CategoriaMaterialRepository;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialCreateService;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialDeleteService;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriaMaterialBean {

    @Bean
    public CategoriaMaterialMapper categoriaMaterialMapper() {
        return new CategoriaMaterialMapper();
    }

    @Bean
    public CategoriaMaterialCreateService categoriaMaterialCreateService(CategoriaMaterialRepository repository) {
        return new CategoriaMaterialCreateService(repository);
    }

    @Bean
    public CategoriaMaterialEditService categoriaMaterialEditService(
            CategoriaMaterialDao dao, CategoriaMaterialRepository repository) {
        return new CategoriaMaterialEditService(dao, repository);
    }

    @Bean
    public CategoriaMaterialDeleteService categoriaMaterialDeleteService(
            CategoriaMaterialRepository repository, CategoriaMaterialDao dao) {
        return new CategoriaMaterialDeleteService(repository, dao);
    }

}
