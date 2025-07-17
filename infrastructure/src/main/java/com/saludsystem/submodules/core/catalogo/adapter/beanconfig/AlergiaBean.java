package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;
import com.saludsystem.submodules.catalogo.service.alergia.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlergiaBean {

    @Bean
    public AlergiaByIdService alergiaByIdService(AlergiaDao dao) {
        return new AlergiaByIdService(dao);
    }

    @Bean
    public AlergiaAllService alergiaAllService(AlergiaDao dao) {
        return new AlergiaAllService(dao);
    }

    @Bean
    public AlergiaDeleteService alergiaDeleteService(AlergiaRepository repository) {
        return new AlergiaDeleteService(repository);
    }

    @Bean
    public AlergiaEditService alergiaEditService(AlergiaRepository repository) {
        return new AlergiaEditService(repository);
    }

    @Bean
    public AlergiaCreateService alergiaCreateService(AlergiaRepository repository) {
        return new AlergiaCreateService(repository);
    }

    @Bean
    public AlergiaListService alergiaListService(AlergiaDao dao) {
        return new AlergiaListService(dao);
    }
}
