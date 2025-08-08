package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import com.saludsystem.submodules.paciente.mapper.PConsentimientoMapper;
import com.saludsystem.submodules.paciente.port.dao.PConsentimientoDao;
import com.saludsystem.submodules.paciente.port.repository.PConsentimientoRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.pconsentimiento.PConsentimientoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PConsentimientoBean {

    @Bean
    public PConsentimientoMapper pConsentimientoMapper() {
        return new PConsentimientoMapper();
    }

    @Bean
    public PConsentimientoCreateService pConsentimientoCreateService(PConsentimientoRepository repository) {
        return new PConsentimientoCreateService(repository);
    }

    @Bean
    public PConsentimientoEditService pConsentimientoEditService
            (PConsentimientoDao dao, PConsentimientoRepository repository) {
        return new PConsentimientoEditService(dao, repository);
    }

    @Bean
    public PConsentimientoDeleteService pConsentimientoDeleteService
            (PConsentimientoRepository repository, PConsentimientoDao dao) {
        return new PConsentimientoDeleteService(repository, dao);
    }

}