package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.principal.port.repository.AseguradoraRepository;
import com.saludsystem.submodules.principal.service.aseguradora.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AseguradoraBean {

    @Bean
    public AseguradoraCreateService aseguradoraCreateService(AseguradoraRepository aseguradoraRepository) {
        return new AseguradoraCreateService(aseguradoraRepository);
    }

    @Bean
    public AseguradoraEdiService aseguradoraEdiService(AseguradoraRepository aseguradoraRepository) {
        return new AseguradoraEdiService(aseguradoraRepository);
    }

    @Bean
    public AseguradoraDeleteService aseguradoraDeleteService(AseguradoraRepository aseguradoraRepository) {
        return new AseguradoraDeleteService(aseguradoraRepository);
    }

    @Bean
    public AseguradoraListService aseguradoraListService(AseguradoraDao aseguradoraDao) {
        return new AseguradoraListService(aseguradoraDao);
    }

    @Bean
    public AseguradoraByIdService aseguradoraByIdService(AseguradoraDao aseguradoraDao) {
        return new AseguradoraByIdService(aseguradoraDao);
    }

    @Bean
    public AseguradoraAllService aseguradoraAllService(AseguradoraDao aseguradoraDao) {
        return new AseguradoraAllService(aseguradoraDao);
    }

}
