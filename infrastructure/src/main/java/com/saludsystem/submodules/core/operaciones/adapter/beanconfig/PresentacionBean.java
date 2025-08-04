package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.port.dao.PresentacionDao;
import com.saludsystem.submodules.operaciones.port.repository.PresentacionRepository;
import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionCreateService;
import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionDeleteService;
import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentacionBean {

    @Bean
    public PresentacionMapper presentacionMapper() {
        return new PresentacionMapper();
    }

    @Bean
    public PresentacionCreateService presentacionCreateService(PresentacionRepository repository) {
        return new PresentacionCreateService(repository);
    }

    @Bean
    public PresentacionEditService presentacionEditService(PresentacionDao dao, PresentacionRepository repository) {
        return new PresentacionEditService(dao, repository);
    }

    @Bean
    public PresentacionDeleteService presentacionDeleteService(PresentacionRepository repository, PresentacionDao dao) {
        return new PresentacionDeleteService(repository, dao);
    }

}
