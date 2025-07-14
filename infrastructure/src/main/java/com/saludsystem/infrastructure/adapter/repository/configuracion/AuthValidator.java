package com.saludsystem.infrastructure.adapter.repository.configuracion;

import com.saludsystem.infrastructure.adapter.entity.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapter.jparepository.configuracion.UserJpaRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {

    private final UserJpaRepository userJpaRepository;

    public AuthValidator(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userJpaRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public boolean isAdmin(UserEntity user) {
        return "ADMINISTRADOR".equals(user.getRol().getNombre());
    }

    public void validateAdminAccess() {
        UserEntity user = getCurrentUser();
        if (!isAdmin(user)) {
            throw new AccessDeniedException("No tienes permisos para realizar esta operación");
        }
    }
}