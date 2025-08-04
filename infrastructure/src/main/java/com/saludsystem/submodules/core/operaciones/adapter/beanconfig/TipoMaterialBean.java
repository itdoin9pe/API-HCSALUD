package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.TipoMaterialMapper;
import com.saludsystem.submodules.operaciones.port.dao.TipoMaterialDao;
import com.saludsystem.submodules.operaciones.port.repository.TipoMaterialRepository;
import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialCreateService;
import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialDeleteService;
import com.saludsystem.submodules.operaciones.service.tipo_material.TipoMaterialEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoMaterialBean {

    @Bean
    public TipoMaterialMapper tipoMaterialMapper() {
        return new TipoMaterialMapper();
    }

    @Bean
    public TipoMaterialCreateService tipoMaterialCreateService(TipoMaterialRepository repository) {
        return new TipoMaterialCreateService(repository);
    }

    @Bean
    public TipoMaterialEditService tipoMaterialEditService(TipoMaterialDao dao, TipoMaterialRepository repository) {
        return new TipoMaterialEditService(dao, repository);
    }

    @Bean
    public TipoMaterialDeleteService tipoMaterialDeleteService(TipoMaterialRepository repository, TipoMaterialDao dao) {
        return new TipoMaterialDeleteService(repository, dao);
    }

}
