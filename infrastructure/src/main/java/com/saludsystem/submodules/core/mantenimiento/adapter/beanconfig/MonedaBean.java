package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.MonedaRepository;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaCreateService;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaDeleteService;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonedaBean {

    @Bean
    public MonedaMapper monedaMapper() {
        return new MonedaMapper();
    }

    @Bean
    public MonedaCreateService monedaCreateService(MonedaRepository repository) {
        return new MonedaCreateService(repository);
    }

    @Bean
    public MonedaEditService monedaEditService(MonedaDao dao, MonedaRepository repository) {
        return new MonedaEditService(dao, repository);
    }

    @Bean
    public MonedaDeleteService monedaDeleteService(MonedaRepository repository, MonedaDao dao) {
        return new MonedaDeleteService(repository, dao);
    }

}
