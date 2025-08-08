package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.paciente.port.repository.PacienteRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.paciente.PacienteEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PacienteBean {

    @Bean
    public PacienteMapper pacienteMapper(){
        return new PacienteMapper();
    }

    @Bean
    public PacienteCreateService pacienteCreateService(PacienteRepository repository) {
        return new PacienteCreateService(repository);
    }

    @Bean
    public PacienteEditService pacienteEditService(PacienteDao dao, PacienteRepository repository) {
        return new PacienteEditService(dao, repository);
    }

    @Bean
    public PacienteDeleteService pacienteDeleteService(PacienteRepository repository, PacienteDao dao) {
        return new PacienteDeleteService(repository, dao);
    }

}