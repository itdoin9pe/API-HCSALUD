package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.principal.port.repository.EmpresaRepository;
import com.saludsystem.submodules.principal.service.empresa.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpresaBean {

    @Bean
    public EmpresaCreateService empresaCreateService(EmpresaRepository empresaRepository) {
        return new EmpresaCreateService(empresaRepository);
    }

    @Bean
    public EmpresaDeleteService empresaDeleteService(EmpresaRepository empresaRepository) {
        return new EmpresaDeleteService(empresaRepository);
    }

    @Bean
    public EmpresaEditService empresaEditService(EmpresaRepository empresaRepository) {
        return new EmpresaEditService(empresaRepository);
    }

    @Bean
    public EmpresaListService empresaListService(EmpresaDao empresaDao) {
        return new EmpresaListService(empresaDao);
    }

    @Bean
    public EmpresaByIdService empresaByIdService(EmpresaDao empresaDao) {
        return new EmpresaByIdService(empresaDao);
    }

    @Bean
    public EmpresaAllService empresaAllService(EmpresaDao empresaDao) {
        return new EmpresaAllService(empresaDao);
    }

}
