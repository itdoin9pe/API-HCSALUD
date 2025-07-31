package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.TipoCitadoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoCitadoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoCitadoRepository;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoCreateService;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoDeleteService;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoCitadoBean {

    @Bean
    public TipoCitadoMapper tipoCitadoMapper() {
        return new TipoCitadoMapper();
    }

    @Bean
    public TipoCitadoCreateService tipoCitadoCreateService(TipoCitadoRepository repository) {
        return new TipoCitadoCreateService(repository);
    }

    @Bean
    public TipoCitadoEditService tipoCitadoEditService(TipoCitadoDao dao, TipoCitadoRepository repository) {
        return new TipoCitadoEditService(dao, repository);
    }

    @Bean
    public TipoCitadoDeleteService tipoCitadoDeleteService(TipoCitadoRepository repository, TipoCitadoDao dao) {
        return new TipoCitadoDeleteService(repository, dao);
    }

}
