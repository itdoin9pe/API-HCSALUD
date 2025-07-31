package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.catalogo.port.repository.PlanRepository;
import com.saludsystem.submodules.catalogo.service.plan.PlanCreateService;
import com.saludsystem.submodules.catalogo.service.plan.PlanDeleteService;
import com.saludsystem.submodules.catalogo.service.plan.PlanEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanBean {

    @Bean
    public PlanMapper planMapper() {
        return new PlanMapper();
    }

    @Bean
    public PlanCreateService planCreateService(PlanRepository planRepository) {
        return new PlanCreateService(planRepository);
    }

    @Bean
    public PlanEditService planEditService(PlanDao dao, PlanRepository planRepository) {
        return new PlanEditService(dao, planRepository);
    }

    @Bean
    public PlanDeleteService planDeleteService(PlanRepository planRepository, PlanDao dao) {
        return new PlanDeleteService(planRepository, dao);
    }

}