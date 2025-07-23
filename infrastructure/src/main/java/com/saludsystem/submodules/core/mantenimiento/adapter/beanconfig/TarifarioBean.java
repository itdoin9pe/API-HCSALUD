package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;
import com.saludsystem.submodules.mantenimiento.service.tarifario.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TarifarioBean {

    @Bean
    public TarifarioCreateService tarifarioCreateService(TarifarioRepository repository) {
        return new TarifarioCreateService(repository);
    }

    @Bean
    public TarifarioEditService tarifarioEditService(TarifarioRepository repository) {
        return new TarifarioEditService(repository);
    }

    @Bean
    public TarifarioDeleteService tarifarioDeleteService(TarifarioRepository repository) {
        return new TarifarioDeleteService(repository);
    }

    @Bean
    public TarifarioListService tarifarioListService(TarifarioDao dao) {
        return new TarifarioListService(dao);
    }

    @Bean
    public TarifarioByIdService tarifarioByIdService(TarifarioDao dao) {
        return new TarifarioByIdService(dao);
    }

    @Bean
    public TarifarioAllService tarifarioAllService(TarifarioDao dao) {
        return new TarifarioAllService(dao);
    }

}
