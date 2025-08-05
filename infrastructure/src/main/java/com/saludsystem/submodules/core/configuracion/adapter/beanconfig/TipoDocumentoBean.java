package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.mapper.TipoDocumentoMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.TipoDocumentoDao;
import com.saludsystem.submodules.configuracion.port.in.repository.TipoDocumentoRepository;
import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoCreateService;
import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoDeleteService;
import com.saludsystem.submodules.configuracion.service.tipodocumento.TipoDocumentoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoDocumentoBean {

    @Bean
    public TipoDocumentoMapper tipoDocumentoMapper() {
        return new TipoDocumentoMapper();
    }

    @Bean
    public TipoDocumentoCreateService tipoDocumentoCreateService(TipoDocumentoRepository repository) {
        return new TipoDocumentoCreateService(repository);
    }

    @Bean
    public TipoDocumentoEditService tipoDocumentoEditService
            (TipoDocumentoDao dao, TipoDocumentoRepository repository) {
        return new TipoDocumentoEditService(dao, repository);
    }

    @Bean
    public TipoDocumentoDeleteService tipoDocumentoDeleteService
            (TipoDocumentoRepository repository, TipoDocumentoDao dao) {
        return new TipoDocumentoDeleteService(repository, dao);
    }

}
