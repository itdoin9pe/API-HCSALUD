package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.principal.port.repository.EstudioRepository;
import com.saludsystem.submodules.principal.service.estudio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstudioBean {

    @Bean
    public EstudioCreateService estudioCreateService(EstudioRepository repository) {
        return new EstudioCreateService(repository);
    }

    @Bean
    public EstudioEditService estudioEditService(EstudioRepository repository) {
        return new EstudioEditService(repository);
    }

    @Bean
    public EstudioDeleteService estudioDeleteService(EstudioRepository repository) {
        return new EstudioDeleteService(repository);
    }

    @Bean
    public EstudioListService estudioListService(EstudioDao dao) {
        return new EstudioListService(dao);
    }

    @Bean
    public EstudioByIdService estudioByIdService(EstudioDao dao) {
        return new EstudioByIdService(dao);
    }

    @Bean
    public EstudioAllService estudioAllService(EstudioDao dao) {
        return new EstudioAllService(dao);
    }

}
