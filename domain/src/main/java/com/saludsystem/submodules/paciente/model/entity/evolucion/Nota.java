package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class Nota {
    private Long id;
    private LocalDateTime fecha;
    private String tipo;
    private String contenido;
    private UUID pacienteEvolucion;

    public Nota(Long id, LocalDateTime fecha, String tipo, String contenido, UUID pacienteEvolucion) {
    	this.id=id;
    	this.fecha=fecha;
    	this.tipo=tipo;
    	this.contenido=contenido;
    	this.pacienteEvolucion=pacienteEvolucion;
    }
}