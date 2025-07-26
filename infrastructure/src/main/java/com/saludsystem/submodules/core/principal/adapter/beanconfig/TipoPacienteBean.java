package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.TipoPacienteDao;
import com.saludsystem.submodules.principal.port.repository.TipoPacienteRepository;
import com.saludsystem.submodules.principal.service.tipopaciente.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoPacienteBean {

    @Bean
    public TipoPacienteCreateService tipoPacienteCreateService(TipoPacienteRepository repository) {
        return new TipoPacienteCreateService(repository);
    }

    @Bean
    public TipoPacienteEditService tipoPacienteEditService(TipoPacienteRepository repository) {
        return new TipoPacienteEditService(repository);
    }

    @Bean
    public TipoPacienteDeleteService tipoPacienteDeleteService(TipoPacienteRepository repository) {
        return new TipoPacienteDeleteService(repository);
    }

    @Bean
    public TipoPacienteListService tipoPacienteListService(TipoPacienteDao dao) {
        return new TipoPacienteListService(dao);
    }

    @Bean
    public TipoPacienteByIdService tipoPacienteByIdService(TipoPacienteDao dao) {
        return new TipoPacienteByIdService(dao);
    }

}
