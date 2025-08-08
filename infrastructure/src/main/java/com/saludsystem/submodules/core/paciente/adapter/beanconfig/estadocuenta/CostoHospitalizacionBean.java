package com.saludsystem.submodules.core.paciente.adapter.beanconfig.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.CostoHospitalizacionMapper;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.CostoHospitalizacionDao;
import com.saludsystem.submodules.paciente.port.repository.estadocuenta.CostoHospitalizacionRepository;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionCreateService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionDeleteService;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CostoHospitalizacionBean {

    @Bean
    public CostoHospitalizacionMapper costoHospitalizacionMapper() {
        return new CostoHospitalizacionMapper();
    }

    @Bean
    public CostoHospitalizacionCreateService costoHospitalizacionCreateService
            (CostoHospitalizacionRepository repository) {
        return new CostoHospitalizacionCreateService(repository);
    }

    @Bean
    public CostoHospitalizacionEditService costoHospitalizacionEditService
            (CostoHospitalizacionDao dao, CostoHospitalizacionRepository repository) {
        return new CostoHospitalizacionEditService(dao, repository);
    }

    @Bean
    public CostoHospitalizacionDeleteService costoHospitalizacionDeleteService
            (CostoHospitalizacionRepository repository, CostoHospitalizacionDao dao) {
        return new CostoHospitalizacionDeleteService(repository, dao);
    }

}