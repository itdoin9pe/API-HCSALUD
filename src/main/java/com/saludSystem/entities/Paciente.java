package com.saludSystem.entities;

import com.saludSystem.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Cambiar a Long para adaptarse mejor a ID autogenerados

    @NotBlank(message = "Los nombres del paciente no pueden estar vacíos")
    @Column(name = "nombres", nullable = false)
    private String nombres;

    @NotBlank(message = "Los apellidos del paciente no pueden estar vacíos")
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Email(message = "El email debe ser válido")
    @NotBlank(message = "El email del paciente no puede estar vacío")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "El número de celular no puede estar vacío")
    @Column(name = "celular", nullable = false)
    private String celular;

    @NotBlank(message = "El número de documento no puede estar vacío")
    @Column(name = "numero_documento", unique = true, nullable = false)
    private String numeroDocumento;

    // Relación con la especialidad (enum)
    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad", nullable = false)
    private UserRole especialty;

    // Relación con el usuario creador del registro
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    // Campos de auditoría
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado_en", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado_en")
    private Date updatedAt;
}
