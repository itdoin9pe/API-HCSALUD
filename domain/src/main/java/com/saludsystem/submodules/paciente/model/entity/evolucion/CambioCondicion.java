package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CambioCondicion {
    private Long id;
    private LocalDateTime fecha;
    private String descripcion;
    private UUID pacienteEvolucionId;

    public CambioCondicion(Long id, LocalDateTime fecha, String descripcion, UUID pacienteEvolucionId) {
    	this.id=id;
    	this.fecha=fecha;
    	this.descripcion=descripcion;
    	this.pacienteEvolucionId=pacienteEvolucionId;
    }
}