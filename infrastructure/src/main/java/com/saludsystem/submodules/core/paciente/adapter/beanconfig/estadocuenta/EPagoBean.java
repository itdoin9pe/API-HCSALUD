package com.saludsystem.submodules.core.paciente.adapter.beanconfig.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EPagoDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EPagoRepository;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.epago.EPagoCreateService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.epago.EPagoDeleteService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.epago.EPagoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EPagoBean {

    @Bean
    public EPagoMapper ePagoMapper() {

        return new EPagoMapper();

    }

    @Bean
    public EPagoCreateService ePagoCreateService(EPagoRepository repository) {

        return new EPagoCreateService(repository);

    }

    @Bean
    public EPagoEditService ePagoEditService(EPagoDao dao, EPagoRepository repository) {

        return new EPagoEditService(dao, repository);

    }

    @Bean
    public EPagoDeleteService ePagoDeleteService(EPagoRepository repository, EPagoDao dao) {

        return new EPagoDeleteService(repository, dao);

    }

}