package com.saludsystem.submodules.security;

import com.saludsystem.submodules.adapter.jwt.CustomerUserDetails;
import com.saludsystem.submodules.configuracion.mapper.AuthenticateUserPort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SpringSecurityUserAdapter implements AuthenticateUserPort {

    public UUID getUserId() {
        return getUserDetails().getUserId();
    }

    public UUID getHospitalId() {
        return getUserDetails().getHospitalId();
    }

    private CustomerUserDetails getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomerUserDetails userDetails) {
            return userDetails;
        }
        throw new IllegalStateException("No authenticated user found");
    }
}
