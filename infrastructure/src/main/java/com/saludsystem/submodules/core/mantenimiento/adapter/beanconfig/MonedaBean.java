package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;
import com.saludsystem.submodules.mantenimiento.service.moneda.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonedaBean {

    @Bean
    public MonedaCreateService monedaCreateService(MonedaRepository repository) {
        return new MonedaCreateService(repository);
    }

    @Bean
    public MonedaEditService monedaEditService(MonedaRepository repository) {
        return new MonedaEditService(repository);
    }

    @Bean
    public MonedaDeleteService monedaDeleteService(MonedaRepository repository) {
        return new MonedaDeleteService(repository);
    }

    @Bean
    public MonedaListService monedaListService(MonedaDao dao) {
        return new MonedaListService(dao);
    }

    @Bean
    public MonedaByIdService monedaByIdService(MonedaDao dao) {
        return new MonedaByIdService(dao);
    }

    @Bean
    public MonedaAllService monedaAllService(MonedaDao dao) {
        return new MonedaAllService(dao);
    }
}
