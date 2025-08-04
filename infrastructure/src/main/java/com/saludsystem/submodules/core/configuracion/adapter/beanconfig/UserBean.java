package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.mapper.UsuarioMapper;
import com.saludsystem.submodules.configuracion.port.in.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.in.repository.UserRepository;
import com.saludsystem.submodules.configuracion.service.user.UserCreateService;
import com.saludsystem.submodules.configuracion.service.user.UserDeleteService;
import com.saludsystem.submodules.configuracion.service.user.UserEditService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {

    @Bean
    public UsuarioMapper usuarioMapper() {
        return new UsuarioMapper();
    }

    @Bean
    public UserCreateService userCreateService(UserRepository userRepository) {
        return new UserCreateService(userRepository);
    }

    @Bean
    public UserEditService userEditService(UserDao userDao, UserRepository userRepository) {
        return new UserEditService(userDao, userRepository);
    }

    @Bean
    public UserDeleteService userDeleteService(UserRepository userRepository, UserDao userDao) {
        return new UserDeleteService(userRepository, userDao);
    }

}