package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.catalogo.port.repository.EspecialidadRepository;
import com.saludsystem.submodules.catalogo.service.especialidad.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EspecialidadBean {

    @Bean
    public EspecialidadCreateService especialidadCreateService(EspecialidadRepository repository) {
        return new EspecialidadCreateService(repository);
    }

    @Bean
    public EspecialidadEditService especialidadEditService(EspecialidadRepository repository) {
        return new EspecialidadEditService(repository);
    }

    @Bean
    public EspecialidadDeleteService especialidadDeleteService(EspecialidadRepository repository) {
        return new EspecialidadDeleteService(repository);
    }

    @Bean
    public EspecialidadListService especialidadListService(EspecialidadDao dao) {
        return new EspecialidadListService(dao);
    }

    @Bean
    public EspecialidadByIdService especialidadByIdService(EspecialidadDao dao) {
        return new EspecialidadByIdService(dao);
    }

    @Bean
    public EspecialidadAllService especialidadAllService(EspecialidadDao dao) {
        return new EspecialidadAllService(dao);
    }

}
