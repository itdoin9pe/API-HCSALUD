package com.saludsystem.submodules.security;

import com.saludsystem.submodules.adapter.entity.configuracion.UserEntity;
import com.saludsystem.submodules.adapter.jpa.interfaces.configuracion.UserJpaRepository;
import com.saludsystem.submodules.security.jwt.CustomerUserDetails;
import jakarta.transaction.Transactional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;

    public UserDetailsServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        //return UserDetailsImpl.build(user);
        return new CustomerUserDetails(user); // o una clase compatible con tu login
    }
}
