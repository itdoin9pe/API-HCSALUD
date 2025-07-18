package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.catalogo.port.repository.ConsentimientoRepository;
import com.saludsystem.submodules.catalogo.service.consentimiento.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsentimientoBean {

    @Bean
    public ConsentimientoAllService consentimientoAllService(ConsentimientoDao dao) {
        return new ConsentimientoAllService(dao);
    }

    @Bean
    public ConsentimientoByIdService consentimientoByIdService(ConsentimientoDao dao) {
        return new ConsentimientoByIdService(dao);
    }

    @Bean
    public ConsentimientoListService consentimientoListService(ConsentimientoDao dao) {
        return new ConsentimientoListService(dao);
    }

    @Bean
    public ConsentimientoCreateService consentimientoCreateService(ConsentimientoRepository repository) {
        return new ConsentimientoCreateService(repository);
    }

    @Bean
    public ConsentimientoEditService consentimientoEditService(ConsentimientoRepository repository) {
        return new ConsentimientoEditService(repository);
    }

    @Bean
    public ConsentimientoDeleteService consentimientoDeleteService(ConsentimientoRepository repository) {
        return new ConsentimientoDeleteService(repository);
    }
}
