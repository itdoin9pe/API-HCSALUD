package com.saludsystem.submodules.core.operaciones.adapter.beanconfig;

import com.saludsystem.submodules.operaciones.mapper.ProductoMapper;
import com.saludsystem.submodules.operaciones.port.dao.ProductoDao;
import com.saludsystem.submodules.operaciones.port.repository.ProductoRepository;
import com.saludsystem.submodules.operaciones.service.producto.ProductoCreateService;
import com.saludsystem.submodules.operaciones.service.producto.ProductoDeleteService;
import com.saludsystem.submodules.operaciones.service.producto.ProductoEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoBean {

    @Bean
    public ProductoMapper productoMapper() {
        return new ProductoMapper();
    }

    @Bean
    public ProductoCreateService productoCreateService(ProductoRepository repository) {
        return new ProductoCreateService(repository);
    }

    @Bean
    public ProductoEditService productoEditService(ProductoDao dao, ProductoRepository repository) {
        return new ProductoEditService(dao, repository);
    }

    @Bean
    public ProductoDeleteService productoDeleteService(ProductoRepository repository, ProductoDao dao) {
        return new ProductoDeleteService(repository, dao);
    }

}
