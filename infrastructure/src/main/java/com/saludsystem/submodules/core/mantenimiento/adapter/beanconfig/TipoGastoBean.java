package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.TipoGastoRepository;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoGastoBean {

    @Bean
    public TipoGastoCreateService tipoGastoCreateService(TipoGastoRepository repository) {
        return new TipoGastoCreateService(repository);
    }

    @Bean
    public TipoGastoEditService tipoGastoEditService(TipoGastoRepository repository) {
        return new TipoGastoEditService(repository);
    }

    @Bean
    public TipoGastoDeleteService tipoGastoDeleteService(TipoGastoRepository repository) {
        return new TipoGastoDeleteService(repository);
    }

    @Bean
    public TipoGastoListService tipoGastoListService(TipoGastoDao dao) {
        return new TipoGastoListService(dao);
    }

    @Bean
    public TipoGastoByIdService tipoGastoByIdService(TipoGastoDao dao) {
        return new TipoGastoByIdService(dao);
    }

    @Bean
    public TipoGastoAllService tipoGastoAllService(TipoGastoDao dao) {
        return new TipoGastoAllService(dao);
    }

}
