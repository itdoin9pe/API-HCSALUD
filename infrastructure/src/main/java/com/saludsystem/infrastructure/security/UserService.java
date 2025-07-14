package com.saludsystem.infrastructure.security;

import com.saludsystem.infrastructure.adapter.entity.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapter.jparepository.configuracion.UserJpaRepository;
import com.saludsystem.infrastructure.rest.exception.ResourceNotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;

@NoArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public UserService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userJpaRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));

        //SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRol().getRoleId().toString());
        // Usa el NOMBRE del rol (ej: "CARDIOLOGO") en lugar del ID
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRol().getNombre());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                //List.of(new SimpleGrantedAuthority(user.getRol().getNombre())) // Asegurar el rol
                Collections.singleton(authority)
        );
    }

    public UserEntity findEntityByUsername(String username) {
        return userJpaRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserEntity findEntityByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("email not found"));
    }

    public boolean existsByUsername(String username){
        return userJpaRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userJpaRepository.existsByEmail(email);
    }

    public void save(UserEntity user){
         userJpaRepository.save(user);
    }

}