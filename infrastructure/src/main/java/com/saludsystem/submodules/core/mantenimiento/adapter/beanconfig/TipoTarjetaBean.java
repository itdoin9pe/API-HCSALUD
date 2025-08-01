package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaCreateService;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaDeleteService;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoTarjetaBean {

    @Bean
    public TipoTarjetaMapper tipoTarjetaMapper() {
        return new TipoTarjetaMapper();
    }

    @Bean
    public TipoTarjetaCreateService tipoTarjetaCreateService(TipoTarjetaRepository repository) {
        return new TipoTarjetaCreateService(repository);
    }

    @Bean
    public TipoTarjetaEditService tipoTarjetaEditService(
            TipoTarjetaDao dao, TipoTarjetaRepository repository) {
        return new TipoTarjetaEditService(dao, repository);
    }

    @Bean
    public TipoTarjetaDeleteService tipoTarjetaDeleteService(
            TipoTarjetaRepository repository, TipoTarjetaDao dao) {
        return new TipoTarjetaDeleteService(repository, dao);
    }

}
