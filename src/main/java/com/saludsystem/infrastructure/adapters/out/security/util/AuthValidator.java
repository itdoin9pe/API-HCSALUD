package com.saludsystem.infrastructure.adapters.out.security.util;

import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.UserRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthValidator {

    private final UserRepository userRepository;

    public AuthValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email)
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