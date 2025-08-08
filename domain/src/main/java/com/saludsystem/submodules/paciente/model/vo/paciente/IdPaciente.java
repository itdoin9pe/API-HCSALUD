package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;
import java.util.UUID;

public record IdPaciente(UUID value) {
    public IdPaciente {
        Objects.requireNonNull(value, "El id del paciente no puede ser nulo");
    }
}