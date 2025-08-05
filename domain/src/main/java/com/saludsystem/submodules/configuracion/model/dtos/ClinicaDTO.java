package com.saludsystem.submodules.configuracion.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ClinicaDTO {

    private UUID hospitalId;
    private String nombre;
    private String direccion;
    private String celular;

    @Email(message = "El email debe ser válido")
    private String email;

    private String ruc;
    private Date fecha;
    private String foto;
    private UUID planId;

    @Schema(example = "0")
    private Integer estado;

    public ClinicaDTO(UUID id, String nombre, String direccion, String celular, String email,
                      String ruc, Date fecha, String foto, Integer estado, UUID planId) {

        this.setHospitalId(id);
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setCelular(celular);
        this.setEmail(email);
        this.setRuc(ruc);
        this.setFecha(fecha);
        this.setFoto(foto);
        this.setEstado(estado);
        this.setPlanId(planId);

    }

}