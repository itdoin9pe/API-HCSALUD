package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;
import com.saludsystem.submodules.catalogo.service.tipocitado.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoCitadoBean {

    @Bean
    public TipoCitadoCreateService tipoCitadoCreateService(TipoCitadoRepository repository) {
        return new TipoCitadoCreateService(repository);
    }

    @Bean
    public TipoCitadoEditService tipoCitadoEditService(TipoCitadoRepository repository) {
        return new TipoCitadoEditService(repository);
    }

    @Bean
    public TipoCitadoDeleteService tipoCitadoDeleteService(TipoCitadoRepository repository) {
        return new TipoCitadoDeleteService(repository);
    }

    @Bean
    public TipoCitadoAllService tipoCitadoAllService(TipoCitadoDao dao) {
        return new TipoCitadoAllService(dao);
    }

    @Bean
    public TipoCitadoListService tipoCitadoListService(TipoCitadoDao dao) {
        return new TipoCitadoListService(dao);
    }

    @Bean
    public TipoCitadoByIdService tipoCitadoByIdService(TipoCitadoDao dao) {
        return new TipoCitadoByIdService(dao);
    }

}
