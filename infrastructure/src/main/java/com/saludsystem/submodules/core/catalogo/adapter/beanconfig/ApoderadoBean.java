package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.catalogo.port.repository.ApoderadoRepository;
import com.saludsystem.submodules.catalogo.service.apoderado.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApoderadoBean {

    @Bean
    public ApoderadoCreateService apoderadoCreateService(ApoderadoRepository repository) {
        return new ApoderadoCreateService(repository);
    }

    @Bean
    public ApoderadoEditService apoderadoEditService(ApoderadoRepository repository) {
        return new ApoderadoEditService(repository);
    }

    @Bean
    public ApoderadoDeleteService apoderadoDeleteService(ApoderadoRepository repository) {
        return new ApoderadoDeleteService(repository);
    }

    @Bean
    public ApoderadoByIdService apoderadoByIdService(ApoderadoDao dao) {
        return new ApoderadoByIdService(dao);
    }

    @Bean
    public ApoderadoListService apoderadoListService(ApoderadoDao dao) {
        return new ApoderadoListService(dao);
    }

    @Bean
    public ApoderadoAllService apoderadoAllService(ApoderadoDao dao) {
        return new ApoderadoAllService(dao);
    }
}
