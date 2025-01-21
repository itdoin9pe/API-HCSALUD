package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.SysSalud;
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

import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private UUID pacienteId;

    @NotBlank(message = "El tipo documento no puede estar vacio")
    @Column(name = "tipo_documento", nullable = false)
    private String tipoDocumentoId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais paisId;

    @Column(name = "ubigeo")
    private String ubigeo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipos_paciente_id")
    private TipoPaciente tipoPacienteId;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "nombre_contacto")
    private String nombreContacto;

    @Column(name = "tipo_historia")
    private String tipoHistoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aseguradora_id")
    private Aseguradora aseguradoraId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id")
    private Empresa empresaId;

    @Email(message = "El email debe ser válido")
    @Column(name = "email", unique = true)
    private String email;

    @Lob
    @Column(name = "foto_paciente", columnDefinition = "MEDIUMBLOB")
    private byte[] fotoPaciente;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "observacion")
    private String observacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "informacion_clinica_id")
    private InformacionClinica informacionClinicaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudio_id")
    private Estudio estudioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sede_id")
    private Sede sedeId;

    @NotBlank(message = "El número de celular no puede estar vacío")
    @Column(name = "celular", nullable = false)
    private String celular;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSalud sysSalud;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado_en", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado_en")
    private Date updatedAt;

}