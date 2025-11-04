package com.saludsystem.submodules.security;

import com.saludsystem.submodules.configuracion.port.out.AuthenticateUserPort;
import com.saludsystem.submodules.security.jwt.CustomerUserDetails;

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

 /*
public class SpringSecurityUserAdapter implements AuthenticateUserPort {

    public UUID getUserId() {
        try {
            CustomerUserDetails userDetails = getUserDetails();
            return userDetails != null ? userDetails.getUserId() : null;
        } catch (Exception e) {
            return null; // ← Retornar null en caso de cualquier error
        }
    }

    public UUID getHospitalId() {
        try {
            CustomerUserDetails userDetails = getUserDetails();
            return userDetails != null ? userDetails.getHospitalId() : null;
        } catch (Exception e) {
            return null; // ← Retornar null en caso de cualquier error
        }
    }

    private CustomerUserDetails getUserDetails() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null &&
                    authentication.isAuthenticated() &&
                    !"anonymousUser".equals(authentication.getPrincipal()) &&
                    authentication.getPrincipal() instanceof CustomerUserDetails userDetails) {
                return userDetails;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}

 */