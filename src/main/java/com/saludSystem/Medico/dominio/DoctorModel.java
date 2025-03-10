package com.saludSystem.Medico.dominio;

import com.saludSystem.Catalogo.Especialidad.dominio.EspecialidadModel;
import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicos")
public class DoctorModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_doctor", nullable = false)
    private UUID doctorId;

    @NotBlank(message = "El tipo de documento no puede estar vacío")
    @Column(name = "tipo_documento", nullable = false, length = 20)
    private String tipoDocumento;

    @NotBlank(message = "El número de documento no puede estar vacío")
    @Column(name = "numero_documento", unique = true, nullable = false, length = 15)
    private String numeroDocumento;

    @NotBlank(message = "Los apellidos no pueden estar vacíos")
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;

    @NotBlank(message = "Los nombres no pueden estar vacíos")
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;

    @Column(name = "direccion", length = 255)
    private String direccion;

    @Email(message = "Debe proporcionar un correo válido")
    @Column(name = "correo", unique = true, length = 100)
    private String correo;

    @Column(name = "abreviatura", length = 20)
    private String abreviatura;

    @Column(name = "rne", length = 15)
    private String rne;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "celular", length = 15)
    private String celular;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "sexo", length = 10)
    private String sexo;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", nullable = false)
    private EspecialidadModel especialidadId;

    @Column(name = "colegiatura", length = 20)
    private String colegiatura;

    @Column(name = "color", length = 7)
    private String color;

    @NotNull(message = "El estado no puede ser nulo")
    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "foto_doctor", nullable = true)
    private String fotoDoctor;

    @Column(name = "foto_firma", nullable = true)
    private String fotoFirma;

}