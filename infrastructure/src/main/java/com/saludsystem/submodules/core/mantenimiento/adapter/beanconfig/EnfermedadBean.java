package com.saludsystem.submodules.core.mantenimiento.adapter.beanconfig;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadCreateService;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadDeleteService;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnfermedadBean {

    @Bean
    public EnfermedadMapper enfermedadMapper() {
        return new EnfermedadMapper();
    }

    @Bean
    public EnfermedadCreateService enfermedadCreateService(EnfermedadRepository repository) {
        return new EnfermedadCreateService(repository);
    }

    @Bean
    public EnfermedadEditService enfermedadEditService(EnfermedadDao dao, EnfermedadRepository repository) {
        return new EnfermedadEditService(dao, repository);
    }

    @Bean
    public EnfermedadDeleteService enfermedadDeleteService(EnfermedadRepository repository, EnfermedadDao dao) {
        return new EnfermedadDeleteService(repository, dao);
    }

}