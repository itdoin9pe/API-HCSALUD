package com.saludsystem.submodules.paciente.model.entity.evolucion;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class AltaMedica {
    private Long id;
    private LocalDateTime fecha;
    private String resumenFinal;
    private UUID pacienteEvolucionId;

    public AltaMedica(Long id, LocalDateTime fecha, String resumenFinal, UUID pacienteEvolucionId) {
    	this.id=id;
    	this.fecha=fecha;
    	this.resumenFinal=resumenFinal;
    	this.pacienteEvolucionId=pacienteEvolucionId;
    }
}