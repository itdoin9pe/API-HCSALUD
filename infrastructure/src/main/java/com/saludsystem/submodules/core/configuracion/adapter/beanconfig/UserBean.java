package com.saludsystem.submodules.core.configuracion.adapter.beanconfig;

import com.saludsystem.submodules.configuracion.port.dao.UserDao;
import com.saludsystem.submodules.configuracion.port.out.PasswordEncoderPort;
import com.saludsystem.submodules.configuracion.port.repository.UserRepository;
import com.saludsystem.submodules.configuracion.service.*;
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
    public UserListService userListService(UserDao userDao) {
        return new UserListService(userDao);
    }

    @Bean
    public UserCreateService userCreateService(UserRepository userRepository, PasswordEncoderPort encoderPort){
        return new UserCreateService(userRepository, encoderPort);
    }

    @Bean
    public UserDeleteService userDeleteService(UserRepository userRepository){
        return new UserDeleteService(userRepository);
    }

    @Bean
    public UserEditService userEditService(UserRepository userRepository){
        return new UserEditService(userRepository);
    }

}