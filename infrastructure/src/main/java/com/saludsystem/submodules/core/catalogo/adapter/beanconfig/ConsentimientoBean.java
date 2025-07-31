package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoCreateService;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoDeleteService;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsentimientoBean {

    @Bean
    public ConsentimientoMapper consentimientoMapper() {
        return new ConsentimientoMapper();
    }

    @Bean
    public ConsentimientoCreateService consentimientoCreateService(ConsentimientoRepository repository) {
        return new ConsentimientoCreateService(repository);
    }

    @Bean
    public ConsentimientoEditService consentimientoEditService(
            ConsentimientoDao dao, ConsentimientoRepository repository) {
        return new ConsentimientoEditService(dao, repository);
    }

    @Bean
    public ConsentimientoDeleteService consentimientoDeleteService(
            ConsentimientoRepository repository, ConsentimientoDao dao) {
        return new ConsentimientoDeleteService(repository, dao);
    }

}
