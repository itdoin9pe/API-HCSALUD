package com.saludSystem.Configuracion.Roles.aplicacion.services;

import com.saludSystem.Configuracion.Roles.dominio.RoleModel;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RolePrefixResolver {
    // Mapeo de nombres de rol a prefijos (puedes externalizarlo a BD si lo prefieres)
    private static final Map<String, String> ROLE_TO_PREFIX = Map.of(
            "CARDIOLOGO", "C",
            "ODONTOLOGO", "K",
            "PEDIATRA", "P",
            "GENERAL", "G",
            "MEDICO", "M"
    );

    public String resolvePrefixFromRole(RoleModel role) {
        String roleName = role.getNombre().toUpperCase();
        return ROLE_TO_PREFIX.getOrDefault(roleName, null);
    }

}