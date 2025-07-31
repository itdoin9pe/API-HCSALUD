package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoCreateService;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoDeleteService;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicamentoBean {

    @Bean
    public MedicamentoMapper medicamentoMapper() {
        return new MedicamentoMapper();
    }

    @Bean
    public MedicamentoCreateService medicamentoCreateService(MedicamentoRepository repository) {
        return new MedicamentoCreateService(repository);
    }

    @Bean
    public MedicamentoEditService medicamentoEditService(MedicamentoDao dao, MedicamentoRepository repository) {
        return new MedicamentoEditService(dao, repository);
    }

    @Bean
    public MedicamentoDeleteService medicamentoDeleteService(MedicamentoRepository repository, MedicamentoDao dao) {
        return new MedicamentoDeleteService(repository, dao);
    }

}
