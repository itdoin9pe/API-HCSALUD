package com.saludsystem.submodules.adapter.jwt;

import com.saludsystem.submodules.adapter.entity.configuracion.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class CustomerUserDetails implements UserDetails {

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
        return user.getUsername();
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
        return user.getEstado() == 0;
    }

    // Métodos específicos si necesitas info
    public UUID getUserId() {
        return user.getUserId();
    }

    public String getEmail() {
        return user.getEmail();
    }
}
