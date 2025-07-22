package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.mantenimiento.port.service.CuentaRepository;
import com.saludsystem.submodules.mantenimiento.service.cuenta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CuentaBean {

    @Bean
    public CuentaCreateService cuentaCreateService(CuentaRepository repository) {
        return new CuentaCreateService(repository);
    }

    @Bean
    public CuentaEditService cuentaEditService(CuentaRepository repository) {
        return new CuentaEditService(repository);
    }

    @Bean
    public CuentaDeleteService cuentaDeleteService(CuentaRepository repository) {
        return new CuentaDeleteService(repository);
    }

    @Bean
    public CuentaAllService cuentaAllService(CuentaDao dao) {
        return new CuentaAllService(dao);
    }

    @Bean
    public CuentaListService cuentaListService(CuentaDao dao) {
        return new CuentaListService(dao);
    }

    @Bean
    public CuentaByIdService cuentaByIdService(CuentaDao dao) {
        return new CuentaByIdService(dao);
    }

}
