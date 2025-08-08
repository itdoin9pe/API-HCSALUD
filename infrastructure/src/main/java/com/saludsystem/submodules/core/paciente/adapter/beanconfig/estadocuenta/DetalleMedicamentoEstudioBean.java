package com.saludsystem.submodules.core.paciente.adapter.beanconfig.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.DetalleMedicamentoEstudioDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.DetalleMedicamentoEstudioRepository;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioCreateService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioDeleteService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetalleMedicamentoEstudioBean {

    @Bean
    public DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper() {
        return new DetalleMedicamentoEstudioMapper();
    }

    @Bean
    public DetalleMedicamentoEstudioCreateService detalleMedicamentoEstudioCreateService(
            DetalleMedicamentoEstudioRepository repository
    ){
        return new DetalleMedicamentoEstudioCreateService(repository);
    }

    @Bean
    public DetalleMedicamentoEstudioEditService detalleMedicamentoEstudioEditService(
            DetalleMedicamentoEstudioDao dao, DetalleMedicamentoEstudioRepository repository
    ) {
        return new DetalleMedicamentoEstudioEditService(dao, repository);
    }

    @Bean
    public DetalleMedicamentoEstudioDeleteService detalleMedicamentoEstudioDeleteService(
            DetalleMedicamentoEstudioRepository repository, DetalleMedicamentoEstudioDao dao
    ) {
        return new DetalleMedicamentoEstudioDeleteService(repository, dao);
    }

}