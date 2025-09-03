package com.saludsystem.submodules.catalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter 
@NoArgsConstructor
public class Cliente {
    private UUID id;
    private String tipoDocumento;
    private String nombre;
    private String direccion;
    private String contacto;
    private String telefono;
    private String email;
    private Integer estado;
    
    public Cliente(UUID id, String tipoDocumento, String nombre, String direccion, String contacto, String telefono,
    		String email, Integer estado) {
    	this.id = id;
    	this.tipoDocumento = tipoDocumento;
    	this.nombre = nombre;
    	this.direccion = direccion;
    	this.contacto = contacto;
    	this.telefono = telefono;
    	this.email = email;
    	this.estado = estado;
    }
    public void actualizarTipoDocumento(String tipoDocumento) {
    	if (tipoDocumento != null && !tipoDocumento.isBlank()) {
			this.tipoDocumento=tipoDocumento;
		}
    }
    public void actualizarNombre(String nombre) {
    	if (nombre != null && !nombre.isBlank()) {
			this.nombre=nombre;
		}
    }
    public void actualizarDireccion(String direccion) {
    	if (direccion != null && !direccion.isBlank()) {
			this.direccion=direccion;
		}
    }
    public void actualizarContacto(String contacto) {
    	if (contacto != null && !contacto.isBlank()) {
			this.contacto=contacto;
		}
    }
    public void actualizarTelefono(String telefono) {
    	if (telefono != null && !telefono.isBlank()) {
			this.telefono=telefono;
		}
    }
    public void actualizarEmail(String email) {
    	if (email != null && email.isBlank()) {
			this.email=email;
		}
    }
    public void actualizarEstado(Integer estado) {
    	if (estado != null) {
			this.estado=estado;
		}
    }
}