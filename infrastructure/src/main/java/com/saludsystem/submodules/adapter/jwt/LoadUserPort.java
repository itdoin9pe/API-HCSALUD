package com.saludsystem.submodules.adapter.jwt;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoadUserPort {
    UserDetails loadUserByUsername(String username);
}
