package com.saludSystem.application.services.Configuracion;

import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.domain.exception.ResourceNotFoundException;
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

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));

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
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserEntity findEntityByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("email not found"));
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public void save(UserEntity user){
         userRepository.save(user);
    }

}