package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import com.saludsystem.submodules.paciente.mapper.RecetaMapper;
import com.saludsystem.submodules.paciente.port.dao.RecetaDao;
import com.saludsystem.submodules.paciente.port.repository.RecetaRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecetaBean {

    @Bean
    public RecetaMapper recetaMapper() {

        return new RecetaMapper();

    }

    @Bean
    public RecetaCreateService recetaCreateService(RecetaRepository repository) {

        return new RecetaCreateService(repository);

    }

    @Bean
    public RecetaEditService recetaEditService(RecetaDao dao, RecetaRepository repository) {

        return new RecetaEditService(dao, repository);

    }

    @Bean
    public RecetaDeleteService recetaDeleteService(RecetaRepository repository, RecetaDao dao) {

        return new RecetaDeleteService(repository, dao);

    }

}