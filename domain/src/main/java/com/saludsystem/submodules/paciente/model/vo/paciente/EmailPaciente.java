package com.saludsystem.submodules.paciente.model.vo.paciente;

import java.util.Objects;

public record EmailPaciente(String email) {
    public EmailPaciente {
        Objects.requireNonNull(email, "El email no puede ser nulo");
        email = email.trim().toLowerCase();
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Formato de email inválido");
        }
    }
}