package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoCreateService;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoDeleteService;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoGastoBean {

    @Bean
    public TipoGastoMapper tipoGastoMapper() {
        return new TipoGastoMapper();
    }

    @Bean
    public TipoGastoCreateService tipoGastoCreateService(TipoGastoRepository repository) {
        return new TipoGastoCreateService(repository);
    }

    @Bean
    public TipoGastoEditService tipoGastoEditService(TipoGastoDao dao, TipoGastoRepository repository) {
        return new TipoGastoEditService(dao, repository);
    }

    @Bean
    public TipoGastoDeleteService tipoGastoDeleteService(TipoGastoRepository repository, TipoGastoDao dao) {
        return new TipoGastoDeleteService(repository, dao);
    }

}
