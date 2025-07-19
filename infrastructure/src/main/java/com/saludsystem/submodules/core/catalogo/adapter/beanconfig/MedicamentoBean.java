package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.catalogo.port.repository.MedicamentoRepository;
import com.saludsystem.submodules.catalogo.service.medicamento.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicamentoBean {

    @Bean
    public MedicamentoCreateService medicamentoCreateService(MedicamentoRepository repository) {
        return new MedicamentoCreateService(repository);
    }

    @Bean
    public MedicamentoEditService medicamentoEditService(MedicamentoRepository repository) {
        return new MedicamentoEditService(repository);
    }

    @Bean
    public MedicamentoDeleteService medicamentoDeleteService(MedicamentoRepository repository) {
        return new MedicamentoDeleteService(repository);
    }

    @Bean
    public MedicamentoByIdService medicamentoByIdService(MedicamentoDao dao) {
        return new MedicamentoByIdService(dao);
    }

    @Bean
    public MedicamentoListService medicamentoListService(MedicamentoDao dao) {
        return new MedicamentoListService(dao);
    }

    @Bean
    public MedicamentoAllService medicamentoAllService(MedicamentoDao dao) {
        return new MedicamentoAllService(dao);
    }
}
