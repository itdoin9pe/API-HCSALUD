package com.saludSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    @NotBlank(message = "Los Nombres del paciente no puede estar vacio")
    @Column(name = "nombres")
    private String nombre_paciente;

    @NotBlank(message = "Los Apellidos del paciente no puede estar vacio")
    @Column(name = "apellidos")
    private String apellidos_paciente;

    @NotBlank(message = "La fecha de nacimiento pacientes no puede estar vacio")
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento_paciente;

    @NotBlank(message = "El email del paciente no puede estar vacio")
    @Column(name = "email")
    private String email_paciente;

    @NotBlank(message = "El numero de celular del paciente no puede estar vacio")
    @Column(name = "celular")
    private String celular_paciente;

    @NotBlank(message = "El numero de documento del paciente no puede estar vacio")
    @Column(name = "numero_documento")
    private String numeroDocumento_paciente;
}
