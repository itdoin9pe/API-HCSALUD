package com.saludsystem.submodules.core.principal.adapter.beanconfig;

import com.saludsystem.submodules.principal.mapper.SucursalMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SucursalBean {

    @Bean
    public SucursalMapper sucursalMapper() {

        return new SucursalMapper();

    }

}
