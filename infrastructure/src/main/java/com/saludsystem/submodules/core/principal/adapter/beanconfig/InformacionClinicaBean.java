package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.principal.port.repository.InformacionClinicaRepository;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaCreateService;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaDeleteService;
import com.saludsystem.submodules.principal.service.informacionclinica.InformacionClinicaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InformacionClinicaBean {

    @Bean
    public InformacionClinicaMapper informacionClinicaMapper() {
        return new InformacionClinicaMapper();
    }

    @Bean
    public InformacionClinicaCreateService informacionClinicaCreateService(InformacionClinicaRepository repository) {
        return new InformacionClinicaCreateService(repository);
    }

    @Bean
    public InformacionClinicaEditService informacionClinicaEditService
            (InformacionClinicaDao dao, InformacionClinicaRepository repository) {
        return new InformacionClinicaEditService(dao, repository);
    }

    @Bean
    public InformacionClinicaDeleteService informacionClinicaDeleteService
            (InformacionClinicaRepository repository, InformacionClinicaDao dao) {
        return new InformacionClinicaDeleteService(repository, dao);
    }

}
