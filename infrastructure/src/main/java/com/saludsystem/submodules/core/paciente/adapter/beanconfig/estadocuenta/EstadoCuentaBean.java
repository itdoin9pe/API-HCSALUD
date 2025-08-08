package com.saludsystem.submodules.core.paciente.adapter.beanconfig.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.EstadoCuentaRepository;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaCreateService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaDeleteService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstadoCuentaBean {

    @Bean
    public EstadoCuentaMapper estadoCuentaMapper() {

        return new EstadoCuentaMapper();

    }

    @Bean
    public EstadoCuentaCreateService estadoCuentaCreateService(EstadoCuentaRepository repository) {

        return new EstadoCuentaCreateService(repository);

    }

    @Bean
    public EstadoCuentaEditService estadoCuentaEditService(EstadoCuentaDao dao, EstadoCuentaRepository repository) {

        return new EstadoCuentaEditService(dao, repository);

    }

    @Bean
    public EstadoCuentaDeleteService estadoCuentaDeleteService(EstadoCuentaRepository repository, EstadoCuentaDao dao) {

        return new EstadoCuentaDeleteService(repository, dao);

    }

}