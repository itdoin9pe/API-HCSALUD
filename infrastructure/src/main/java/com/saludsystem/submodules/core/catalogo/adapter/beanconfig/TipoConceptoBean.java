package com.saludsystem.submodules.core.catalogo.adapter.beanconfig;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.catalogo.port.repository.TipoConceptoRepository;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoCreateService;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoDeleteService;
import com.saludsystem.submodules.catalogo.service.tipoconcepto.TipoConceptoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TipoConceptoBean {

    @Bean
    public TipoConceptoMapper tipoConceptoMapper() {
        return new TipoConceptoMapper();
    }

    @Bean
    public TipoConceptoCreateService tipoConceptoCreateService(TipoConceptoRepository repository) {
        return new TipoConceptoCreateService(repository);
    }

    @Bean
    public TipoConceptoEditService tipoConceptoEditService(
            TipoConceptoDao dao, TipoConceptoRepository repository) {
        return new TipoConceptoEditService(dao, repository);
    }

    @Bean
    public TipoConceptoDeleteService tipoConceptoDeleteService(
            TipoConceptoRepository repository, TipoConceptoDao dao) {
        return new TipoConceptoDeleteService(repository, dao);
    }

}
