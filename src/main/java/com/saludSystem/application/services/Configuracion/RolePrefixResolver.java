package com.saludSystem.application.services.Configuracion;

import com.saludSystem.domain.model.Configuracion.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RolePrefixResolver {
    // Mapeo de nombres de rol a prefijos
    private static final Map<String, String> ROLE_TO_PREFIX = Map.of(
            "CARDIOLOGO", "C",
            "ODONTOLOGO", "K",
            "PEDIATRA", "P",
            "GENERAL", "G",
            "MEDICO", "M"
    );

    public String resolvePrefixFromRole(RoleEntity role) {
        String roleName = role.getNombre().toUpperCase();
        return ROLE_TO_PREFIX.getOrDefault(roleName, null);
    }

}