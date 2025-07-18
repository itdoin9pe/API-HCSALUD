package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;
import com.saludsystem.submodules.catalogo.service.cliente.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBean {

    @Bean
    public ClienteAllService clienteAllService(ClienteDao dao) {
        return new ClienteAllService(dao);
    }

    @Bean
    public ClienteByIdService clienteByIdService(ClienteDao dao) {
        return new ClienteByIdService(dao);
    }

    @Bean
    public ClienteListService clienteListService(ClienteDao dao) {
        return new ClienteListService(dao);
    }

    @Bean
    public ClienteCreateService clienteCreateService(ClienteRepository repository) {
        return new ClienteCreateService(repository);
    }

    @Bean
    public ClienteEditService clienteEditService(ClienteRepository repository) {
        return new ClienteEditService(repository);
    }

    @Bean
    public ClienteDeleteService clienteDeleteService(ClienteRepository repository) {
        return new ClienteDeleteService(repository);
    }
}
