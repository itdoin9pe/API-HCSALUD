package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;
import com.saludsystem.submodules.principal.service.informacionclinica.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InformacionClinicaBean {

    @Bean
    public InformacionClinicaCreateService informacionClinicaCreateService(InformacionClinicaRepository repository) {
        return new InformacionClinicaCreateService(repository);
    }

    @Bean
    public InformacionClinicaEditService informacionClinicaEditService(InformacionClinicaRepository repository) {
        return new InformacionClinicaEditService(repository);
    }

    @Bean
    public InformacionClinicaDeleteService informacionClinicaDeleteService(InformacionClinicaRepository repository) {
        return new InformacionClinicaDeleteService(repository);
    }

    @Bean
    public InformacionClinicaListService informacionClinicaListService(InformacionClinicaDao dao) {
        return new InformacionClinicaListService(dao);
    }

    @Bean
    public InformacionClinicaByIdService informacionClinicaByIdService(InformacionClinicaDao dao) {
        return new InformacionClinicaByIdService(dao);
    }

    @Bean
    public InformacionClinicaAllService informacionClinicaAllService(InformacionClinicaDao dao) {
        return new InformacionClinicaAllService(dao);
    }

}
