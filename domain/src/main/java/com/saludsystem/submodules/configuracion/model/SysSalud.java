package com.saludsystem.submodules.configuracion.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class SysSalud {
    private UUID id;
    private String nombre;
    private String direccion;
    private String celular;
    private String email;
    private String ruc;
    private Date fecha;
    private String foto;
    private Integer estado;
    private UUID planId;

    public SysSalud(
            UUID id,
            String nombre,
            String direccion,
            String celular,
            String email,
            String ruc,
            Date fecha,
            String foto,
            Integer estado,
            UUID planId) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
        this.ruc = ruc;
        this.fecha = fecha;
        this.foto = foto;
        this.estado = estado;
        this.planId = planId;
    }

    public void actualizarNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        }
    }

    public void actualizarDireccion(String direccion) {
        if (direccion != null && !direccion.isBlank()) {
            this.direccion = direccion;
        }
    }

    public void actualizarCelular(String celular) {
        if (celular != null && !celular.isBlank()) {
            this.celular = celular;
        }
    }

    public void actualizarEmail(String email) {
        if (email != null && !email.isBlank()) {
            this.email = email;
        }
    }

    public void actualizarRuc(String ruc) {
        if (ruc != null && !ruc.isBlank()) {
            this.ruc = ruc;
        }
    }

    public void actualizarFecha(Date fecha) {
        if (fecha != null && !fecha.after(fecha)) {
            this.fecha = fecha;
        }
    }

    public void actualizarFoto(String foto) {
        if (foto != null && !foto.isBlank()) {
            this.foto = foto;
        }
    }

    public void actualizarEstado(Integer estado) {
        if (estado != null) {
            this.estado = estado;
        }
    }

    public void actualizarPlanId(UUID planId) {
        if (planId != null) {
            this.planId = planId;
        }
    }
}