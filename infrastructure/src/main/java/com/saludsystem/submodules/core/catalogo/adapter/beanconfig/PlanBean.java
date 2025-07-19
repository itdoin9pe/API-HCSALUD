package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;
import com.saludsystem.submodules.catalogo.service.plan.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanBean {

    @Bean
    public PlanCreateService planCreateService(PlanRepository planRepository) {
        return new PlanCreateService(planRepository);
    }

    @Bean
    public PlanEditService planEditService(PlanRepository planRepository) {
        return new PlanEditService(planRepository);
    }

    @Bean
    public PlanDeleteService planDeleteService(PlanRepository planRepository) {
        return new PlanDeleteService(planRepository);
    }

    @Bean
    public PlanByIdService planByIdService(PlanDao planDao) {
        return new PlanByIdService(planDao);
    }

    @Bean
    public PlanListService planListService(PlanDao planDao) {
        return new PlanListService(planDao);
    }

    @Bean
    public PlanAllService planAllService(PlanDao planDao) {
        return new PlanAllService(planDao);
    }

}