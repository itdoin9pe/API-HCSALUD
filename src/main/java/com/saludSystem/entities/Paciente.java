package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.InformacionClinica;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.TipoDocumento;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tipo_documento_id", nullable = false)
    private TipoDocumento tipoDocumento;

    @NotBlank(message = "El número de documento no puede estar vacío")
    @Column(name = "numero_documento", unique = true, nullable = false)
    private String numeroDocumento;

    @NotBlank(message = "Los apellidos del paciente no pueden estar vacíos")
    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @NotBlank(message = "Los nombres del paciente no pueden estar vacíos")
    @Column(name = "nombres", nullable = false)
    private String nombres;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Min(value = 0, message = "La edad debe ser un número positivo")
    @Column(name = "edad")
    private Integer edad;

    @NotNull(message = "El estado no puede estar vacío")
    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "ocupacion")
    private String ocupacion;

    @Column(name = "direccion")
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @Column(name = "ubigeo")
    private String ubigeo;

    @NotNull(message = "El tipo de paciente no puede estar vacío")
    @Column(name = "tipo_paciente_id", nullable = false)
    private Integer tipoPacienteId;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "tipo_historia")
    private String tipoHistoria;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "aseguradora_id")
    private Aseguradora aseguradora;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @Email(message = "El email debe ser válido")
    @Column(name = "email", unique = true)
    private String email;

    @Lob
    @Column(name = "foto_paciente")
    private byte[] fotoPaciente;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "informacion_clinica_id")
    private InformacionClinica informacionClinica;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "estudio_id")
    private Estudio estudio;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "sede_id")
    private Sede sede;

    @NotBlank(message = "El número de celular no puede estar vacío")
    @Column(name = "celular", nullable = false)
    private String celular;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado_en", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado_en")
    private Date updatedAt;
}
