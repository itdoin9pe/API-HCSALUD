package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.mantenimiento.port.repository.BancoRepository;
import com.saludsystem.submodules.mantenimiento.service.banco.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BancoBean {

    @Bean
    public BancoCreateService bancoCreateService(BancoRepository bancoRepository) {
        return new BancoCreateService(bancoRepository);
    }

    @Bean
    public BancoEditService bancoEditService(BancoRepository bancoRepository) {
        return new BancoEditService(bancoRepository);
    }

    @Bean
    public BancoDeleteService bancoDeleteService(BancoRepository bancoRepository) {
        return new BancoDeleteService(bancoRepository);
    }

    @Bean
    public BancoListService bancoListService(BancoDao bancoDao) {
        return new BancoListService(bancoDao);
    }

    @Bean
    public BancoByIdService bancoByIdService(BancoDao bancoDao) {
        return new BancoByIdService(bancoDao);
    }

    @Bean
    public BancoAllService bancoAllService(BancoDao bancoDao) {
        return new BancoAllService(bancoDao);
    }

}
