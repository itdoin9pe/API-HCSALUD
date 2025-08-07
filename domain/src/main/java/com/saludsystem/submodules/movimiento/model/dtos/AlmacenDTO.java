package com.saludsystem.submodules.movimiento.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class AlmacenDTO {

    public AlmacenDTO(UUID almacenId, String nombre, Integer estado, UUID sedeId, UUID sucursalId) {
		// TODO Auto-generated constructor stub
    	this.setAlmacenId(almacenId);
    	this.setNombre(nombre);
    	this.setEstado(estado);
    	this.setSedeId(sedeId);
    	this.setSucursalId(sucursalId);
	}

    private UUID almacenId;
    
    private String nombre;

    @Schema(description = "Estado de almacen", example = "0")
    private Integer estado;

	private UUID sedeId;

	private UUID sucursalId;
    
}