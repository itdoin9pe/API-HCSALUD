package com.saludsystem.submodules.core.cita.adapter.beanconfig;

import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.cita.port.repository.CitaRepository;
import com.saludsystem.submodules.cita.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitaBean {

    @Bean
    public CitaCreateService citaCreateService(CitaRepository repository) {
        return new CitaCreateService(repository);
    }

    @Bean
    public CitaEditService citaEditService(CitaRepository repository) {
        return new CitaEditService(repository);
    }

    @Bean
    public CitaDeleteService citaDeleteService(CitaRepository repository) {
        return new CitaDeleteService(repository);
    }

    @Bean
    public CitaByIdService citaByIdService(CitaDao dao) {
        return new CitaByIdService(dao);
    }

    @Bean
    public CitaListService citaListService(CitaDao dao) {
        return new CitaListService(dao);
    }

    @Bean CitaAllService citaAllService(CitaDao dao) {
        return new CitaAllService(dao);
    }

}
