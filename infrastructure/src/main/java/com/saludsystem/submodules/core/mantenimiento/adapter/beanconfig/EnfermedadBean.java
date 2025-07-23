package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnfermedadBean {

    @Bean
    public EnfermedadCreateService enfermedadCreateService(EnfermedadRepository repository) {
        return new EnfermedadCreateService(repository);
    }

    @Bean
    public EnfermedadEditService enfermedadEditService(EnfermedadRepository repository) {
        return new EnfermedadEditService(repository);
    }

    @Bean
    public EnfermedadDeleteService enfermedadDeleteService(EnfermedadRepository repository) {
        return new EnfermedadDeleteService(repository);
    }

    @Bean
    public EnfermedadAllService enfermedadAllService(EnfermedadDao dao) {
        return new EnfermedadAllService(dao);
    }

    @Bean
    public EnfermedadListService enfermedadListService(EnfermedadDao dao) {
        return new EnfermedadListService(dao);
    }

    @Bean
    public EnfermedadByIdService enfermedadByIdService(EnfermedadDao dao) {
        return new EnfermedadByIdService(dao);
    }

}