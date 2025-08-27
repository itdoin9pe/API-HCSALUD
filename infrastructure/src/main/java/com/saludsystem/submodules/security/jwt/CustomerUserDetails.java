package com.saludsystem.submodules.security.jwt;

import com.saludsystem.submodules.core.configuracion.adapter.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerUserDetails implements UserDetails {
	
    @Serial
    private static final long serialVersionUID = 1L;

    private final UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roleName = "ADMINISTRADOR";
        if (user.getRol() != null && user.getRol().getNombre() != null) {
            roleName = user.getRol().getNombre();
        }
        return List.of(new SimpleGrantedAuthority(roleName));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        //return user.getUsername();
        return user.getEmail(); // o user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEstado() == 1;
    }

    // Métodos específicos si necesitas info
    public UUID getUserId() {
        return user.getUserId();
    }

    public UUID getHospitalId() {
        return user.getHospital().getHospitalId();
    }

    public String getEmail() {
        return user.getEmail();
    }
}
