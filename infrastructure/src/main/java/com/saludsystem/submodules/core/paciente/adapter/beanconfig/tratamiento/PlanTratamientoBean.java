package com.saludsystem.submodules.core.paciente.adapter.beanconfig.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import com.saludsystem.submodules.paciente.port.repository.tratamiento.PlanTratamientoRepository;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoCreateService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoDeleteService;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoEdtiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanTratamientoBean {

    @Bean
    public PlanTratamientoMapper planTratamientoMapper() {

        return new PlanTratamientoMapper();

    }

    @Bean
    public PlanTratamientoCreateService planTratamientoCreateService(PlanTratamientoRepository repository) {

        return new PlanTratamientoCreateService(repository);

    }

    @Bean
    public PlanTratamientoEdtiService planTratamientoEdtiService(
            PlanTratamientoDao dao, PlanTratamientoRepository repository) {

        return new PlanTratamientoEdtiService(dao, repository);

    }

    @Bean
    public PlanTratamientoDeleteService planTratamientoDeleteService(
            PlanTratamientoRepository repository, PlanTratamientoDao dao) {

        return new PlanTratamientoDeleteService(repository, dao);

    }

}