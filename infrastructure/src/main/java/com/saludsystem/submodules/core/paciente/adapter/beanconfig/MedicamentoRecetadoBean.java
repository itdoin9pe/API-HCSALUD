package com.saludsystem.submodules.core.paciente.adapter.beanconfig;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.port.dao.MedicamentoRecetadoDao;
import com.saludsystem.submodules.paciente.port.repository.MedicamentoRecetadoRepository;
import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoCreateService;
import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoDeleteService;
import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicamentoRecetadoBean {

    @Bean
    public MedicamentoRecetadoMapper medicamentoRecetadoMapper() {
        return new MedicamentoRecetadoMapper();
    }

    @Bean
    public MedicamentoRecetadoCreateService medicamentoRecetadoCreateService
            (MedicamentoRecetadoRepository repository) {
        return new MedicamentoRecetadoCreateService(repository);
    }

    @Bean
    public MedicamentoRecetadoEditService medicamentoRecetadoEditService
            (MedicamentoRecetadoDao dao, MedicamentoRecetadoRepository repository) {
        return new MedicamentoRecetadoEditService(dao, repository);
    }

    @Bean
    public MedicamentoRecetadoDeleteService medicamentoRecetadoDeleteService
            (MedicamentoRecetadoRepository repository, MedicamentoRecetadoDao dao) {
        return new MedicamentoRecetadoDeleteService(repository, dao);
    }

}