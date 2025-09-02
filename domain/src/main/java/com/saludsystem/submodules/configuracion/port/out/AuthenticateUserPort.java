    package com.saludsystem.submodules.configuracion.port.out;

    import java.util.UUID;

    public interface AuthenticateUserPort {
        UUID getUserId();
        UUID getHospitalId();
    }
