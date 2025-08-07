package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import com.saludsystem.submodules.paciente.port.repository.EstudioMedicoRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudioMedicoBean {

    @Bean
    public EstudioMedicoMapper estudioMedicoMapper() {
        return new EstudioMedicoMapper();
    }

    @Bean
    public EstudioMedicoCreateService estudioMedicoCreateService(EstudioMedicoRepository repository) {
        return new EstudioMedicoCreateService(repository);
    }

    @Bean
    public EstudioMedicoEditService estudioMedicoEditService(EstudioMedicoDao dao, EstudioMedicoRepository repository) {
        return new EstudioMedicoEditService(dao, repository);
    }

    @Bean
    public EstudioMedicoDeleteService estudioMedicoDeleteService
            (EstudioMedicoRepository repository, EstudioMedicoDao dao) {
        return new EstudioMedicoDeleteService(repository, dao);
    }

}