package com.saludsystem.submodules.sections.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.port.in.service.user.*;
import com.saludsystem.submodules.configuracion.port.out.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.out.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {

    @Bean
    public UserAllService userAllService(UserDao userDao){
        return new UserAllService(userDao);
    }

    @Bean
    public UserByIdService userByIdService(UserDao userDao){
        return new UserByIdService(userDao);
    }

    @Bean
    public UserCreateService userCreateService(UserRepository userRepository){
        return new UserCreateService(userRepository);
    }

    @Bean
    public UserDeleteService userDeleteService(UserDao userDao, UserRepository userRepository){
        return new UserDeleteService(userDao, userRepository);
    }

    @Bean
    public UserEditService userEditService(UserDao userDao, UserRepository userRepository){
        return new UserEditService(userDao, userRepository);
    }

}