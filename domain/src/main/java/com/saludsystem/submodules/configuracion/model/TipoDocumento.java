package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter 
@NoArgsConstructor
public class TipoDocumento {
    private UUID id;
    private String tipoComprobante;
    private String serie;
    private Integer inicio;
    private Integer fin;
    private Integer correlativoActual;
    private Integer estado;
    
    public TipoDocumento(UUID id, String tipoComprobante, String serie, Integer inicio, Integer fin, 
    		Integer correlativoActual, Integer estado) {
    	this.id=id;
    	this.tipoComprobante=tipoComprobante;
    	this.serie=serie;
    	this.inicio=inicio;
    	this.fin=fin;
    	this.correlativoActual=correlativoActual;
    	this.estado=estado;
    }
}