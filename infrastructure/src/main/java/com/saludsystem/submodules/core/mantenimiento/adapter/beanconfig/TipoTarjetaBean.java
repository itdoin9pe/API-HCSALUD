package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoTarjetaRepository;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoTarjetaBean {

    @Bean
    public TipoTarjetaCreateService tipoTarjetaCreateService(TipoTarjetaRepository repository) {
        return new TipoTarjetaCreateService(repository);
    }

    @Bean
    public TipoTarjetaEditService tipoTarjetaEditService(TipoTarjetaRepository repository) {
        return new TipoTarjetaEditService(repository);
    }

    @Bean
    public TipoTarjetaDeleteService tipoTarjetaDeleteService(TipoTarjetaRepository repository) {
        return new TipoTarjetaDeleteService(repository);
    }

    @Bean
    public TipoTarjetaListService tipoTarjetaListService(TipoTarjetaDao dao) {
        return new TipoTarjetaListService(dao);
    }

    @Bean
    public TipoTarjetaByIdService tipoTarjetaByIdService(TipoTarjetaDao dao) {
        return new TipoTarjetaByIdService(dao);
    }

    @Bean
    public TipoTarjetaAllService tipoTarjetaAllService(TipoTarjetaDao dao) {
        return new TipoTarjetaAllService(dao);
    }

}
