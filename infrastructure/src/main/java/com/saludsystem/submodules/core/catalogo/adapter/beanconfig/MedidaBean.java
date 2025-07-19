package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.catalogo.port.repository.MedidaRepository;
import com.saludsystem.submodules.catalogo.service.medida.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedidaBean {

    @Bean
    public MedidaCreateService medidaCreateService(MedidaRepository repository) {
        return new MedidaCreateService(repository);
    }

    @Bean
    public MedidaEditService medidaEditService(MedidaRepository repository) {
        return new MedidaEditService(repository);
    }

    @Bean
    public MedidaDeleteService medidaDeleteService(MedidaRepository repository) {
        return new MedidaDeleteService(repository);
    }

    @Bean
    public MedidaListService medidaListService(MedidaDao dao) {
        return new MedidaListService(dao);
    }

    @Bean
    public MedidaByIdService medidaByIdService(MedidaDao dao) {
        return new MedidaByIdService(dao);
    }

    @Bean
    public MedidaAllService medidaAllService(MedidaDao dao) {
        return new MedidaAllService(dao);
    }
}
