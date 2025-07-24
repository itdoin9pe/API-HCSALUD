package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoPagoRepository;
import com.saludsystem.submodules.mantenimiento.service.tipopago.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoPagoBean {

    @Bean
    public TipoPagoCreateService tipoPagoCreateService(TipoPagoRepository repository) {
        return new TipoPagoCreateService(repository);
    }

    @Bean
    public TipoPagoEditService tipoPagoEditService(TipoPagoRepository repository) {
        return new TipoPagoEditService(repository);
    }

    @Bean
    public TipoPagoDeleteService tipoPagoDeleteService(TipoPagoRepository repository) {
        return new TipoPagoDeleteService(repository);
    }

    @Bean
    public TipoPagoListService tipoPagoListService(TipoPagoDao dao) {
        return new TipoPagoListService(dao);
    }

    @Bean
    public TipoPagoAllService tipoPagoAllService(TipoPagoDao dao) {
        return new TipoPagoAllService(dao);
    }

    @Bean
    public TipoPagoByIdService tipoPagoByIdService(TipoPagoDao dao) {
        return new TipoPagoByIdService(dao);
    }

}
