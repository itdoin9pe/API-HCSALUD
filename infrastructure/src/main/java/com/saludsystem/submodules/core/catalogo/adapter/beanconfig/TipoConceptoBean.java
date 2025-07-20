package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoConceptoBean {

    @Bean
    public TipoConceptoCreateService tipoConceptoCreateService(TipoConceptoRepository repository) {
        return new TipoConceptoCreateService(repository);
    }

    @Bean
    public TipoConceptoEditService tipoConceptoEditService(TipoConceptoRepository repository) {
        return new TipoConceptoEditService(repository);
    }

    @Bean
    public TipoConceptoDeleteService tipoConceptoDeleteService(TipoConceptoRepository repository) {
        return new TipoConceptoDeleteService(repository);
    }

    @Bean
    public TipoConceptoListService tipoConceptoListService(TipoConceptoDao dao) {
        return new TipoConceptoListService(dao);
    }

    @Bean
    public TipoConceptoByIdService tipoConceptoByIdService(TipoConceptoDao dao) {
        return new TipoConceptoByIdService(dao);
    }

    @Bean
    public TipoConceptoAllService tipoConceptoAllService(TipoConceptoDao dao) {
        return new TipoConceptoAllService(dao);
    }
}
