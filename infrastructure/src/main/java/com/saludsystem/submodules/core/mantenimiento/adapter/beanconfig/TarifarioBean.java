package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioCreateService;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioDeleteService;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioEditService;
import com.saludsystem.submodules.mantenimiento.port.repository.TarifarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TarifarioBean {

    @Bean
    public TarifarioMapper tarifarioMapper() {
        return new TarifarioMapper();
    }

    @Bean
    public TarifarioCreateService tarifarioCreateService(TarifarioRepository repository) {
        return new TarifarioCreateService(repository);
    }

    @Bean
    public TarifarioEditService tarifarioEditService(
            TarifarioDao dao, TarifarioRepository repository) {
        return new TarifarioEditService(dao, repository);
    }

    @Bean
    public TarifarioDeleteService tarifarioDeleteService(TarifarioRepository repository, TarifarioDao dao) {
        return new TarifarioDeleteService(repository, dao);
    }

}
