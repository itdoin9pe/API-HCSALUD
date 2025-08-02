package com.saludsystem.submodules.medico.model.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class DoctorCreateCommand {

    private String tipoDocumento;
    private String numeroDocumento;
    private String apellidos;
    private String nombres;
    private String direccion;
    private String correo;
    private String abreviatura;
    private String rne;
    private LocalDate fechaNacimiento;
    private String celular;
    private String telefono;
    private String sexo;
    private UUID especialidadId;
    private String colegiatura;
    private String color;
    @Schema(example = "0")
    private Integer estado;
    private String fotoDoctor;
    private String fotoFirma;

}