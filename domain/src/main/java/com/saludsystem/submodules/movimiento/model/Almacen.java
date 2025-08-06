package com.saludsystem.submodules.movimiento.model;

import java.util.UUID;

public class Almacen {

    private UUID almacenId;
    private String nombre;
    private Integer estado;

    private UUID sedeId;
    private UUID sucursalId;

    private UUID hospitalId;
    private UUID userId;

    public Almacen(UUID almacenId, String nombre, Integer estado,
                   UUID sedeId, UUID sucursalId, UUID hospitalId, UUID userId) {
        this.almacenId = almacenId;
        this.nombre = nombre;
        this.estado = estado;
        this.sedeId = sedeId;
        this.sucursalId = sucursalId;
        this.hospitalId = hospitalId;
        this.userId = userId;
    }

    public UUID getAlmacenId() {
        return almacenId;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public UUID getSedeId() {
        return sedeId;
    }

    public UUID getSucursalId() {
        return sucursalId;
    }

    public UUID getHospitalId() {
        return hospitalId;
    }

    public UUID getUserId() {
        return userId;
    }

}
