package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter 
@NoArgsConstructor
public class Permiso {
    private UUID id;
    private Boolean delete;
    private Boolean insert;
    private Boolean read;
    private Boolean update;
    private UUID rolId;
    private UUID menuId;
    
    public Permiso(UUID id, Boolean delete, Boolean insert, Boolean read, Boolean update, UUID rolId, UUID menuId) {
    	this.id=id;
    	this.delete=delete;
    	this.insert=insert;
    	this.read=read;
    	this.update=update;
    	this.rolId=rolId;
    	this.menuId=menuId;
    }
}