package com.saludsystem.submodules.core.paciente.adapter.beanconfig.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.CambioCondicionMapper;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.CambioCondicionRepository;
import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionCreateService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionDeleteService;
import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CambioCondicionBean {

    @Bean
    public CambioCondicionMapper cambioCondicionMapper() {

        return new CambioCondicionMapper();

    }

    @Bean
    public CambioCondicionCreateService cambioCondicionCreateService(CambioCondicionRepository repository) {

        return new CambioCondicionCreateService(repository);

    }

    @Bean
    public CambioCondicionEditService cambioCondicionEditService(
            CambioCondicionDao dao, CambioCondicionRepository repository
    ) {

        return new CambioCondicionEditService(dao, repository);

    }

    @Bean
    public CambioCondicionDeleteService cambioCondicionDeleteService(
            CambioCondicionRepository repository, CambioCondicionDao dao
    ) {

        return new CambioCondicionDeleteService(repository, dao);

    }

}