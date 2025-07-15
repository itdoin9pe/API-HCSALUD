package com.saludsystem.submodules.configuracion.model.entity.value_objet.usuario;

public record Foto(String url) {
    public Foto {
        if (url != null && !url.isBlank() && !url.matches("^(https?://).+")) {
            throw new IllegalArgumentException("La URL de la foto debe ser válida.");
        }
    }
}