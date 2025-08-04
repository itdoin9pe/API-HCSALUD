package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.PermisoRepository;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoCreateService;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoDeleteService;
import com.saludsystem.submodules.configuracion.service.permiso.PermisoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PermisoBean {

    @Bean
    public PermisoMapper permisoMapper() {
        return new PermisoMapper();
    }

    @Bean
    public PermisoCreateService permisoCreateService(PermisoRepository repository) {
        return new PermisoCreateService(repository);
    }

    @Bean
    public PermisoEditService permisoEditService(PermisoDao dao, PermisoRepository repository) {
        return new PermisoEditService(dao, repository);
    }

    @Bean
    public PermisoDeleteService permisoDeleteService(PermisoRepository repository, PermisoDao dao) {
        return new PermisoDeleteService(repository, dao);
    }

}
