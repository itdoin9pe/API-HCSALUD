package com.saludsystem.submodules.core.medico.adapter.beanconfig;

import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.medico.port.repository.DoctorRepository;
import com.saludsystem.submodules.medico.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctoBean {

    @Bean
    public DoctorCreateService doctorCreateService(DoctorRepository repository) {
        return new DoctorCreateService(repository);
    }

    @Bean
    public DoctorDeleteService doctorDeleteService(DoctorRepository repository) {
        return new DoctorDeleteService(repository);
    }

    @Bean
    public DoctorEditService doctorEditService(DoctorRepository repository) {
        return new DoctorEditService(repository);
    }

    @Bean
    public DoctorListService doctorListService(DoctorDao dao) {
        return new DoctorListService(dao);
    }

    @Bean
    public DoctorByIdService doctorByIdService(DoctorDao dao) {
        return new DoctorByIdService(dao);
    }

    @Bean
    public DoctorAllService doctorAllService(DoctorDao dao) {
        return new DoctorAllService(dao);
    }

}
