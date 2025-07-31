package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.catalogo.port.repository.AlergiaRepository;
import com.saludsystem.submodules.catalogo.service.alergia.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlergiaBean {

    @Bean
    public AlergiaMapper alergiaMapper() {
        return new AlergiaMapper();
    }

    @Bean
    public AlergiaCreateService alergiaCreateService(AlergiaRepository repository) {
        return new AlergiaCreateService(repository);
    }

    @Bean
    public AlergiaEditService alergiaEditService(AlergiaDao dao, AlergiaRepository repository) {
        return new AlergiaEditService(dao, repository);
    }

    @Bean
    public AlergiaDeleteService alergiaDeleteService(AlergiaRepository repository, AlergiaDao dao) {
        return new AlergiaDeleteService(repository, dao);
    }

}
