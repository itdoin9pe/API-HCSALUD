package com.saludsystem.submodules.sections.paciente.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.sections.principal.adapter.entity.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pacientes")
@Builder
@EqualsAndHashCode(callSuper = true)
public class PacienteEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_paciente", nullable = false)
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
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Min(value = 0, message = "La edad debe ser un número positivo")
    @Column(name = "edad", nullable = false)
    private Integer edad;

    @NotNull(message = "El estado no puede estar vacío")
    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "ocupacion", nullable = false)
    private String ocupacion;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private PaisEntity paisId;

    @Column(name = "departamento", nullable = false)
    private String departamento;

    @Column(name = "provincia", nullable = false)
    private String provincia;

    @Column(name = "distrito", nullable = false)
    private String distrito;

    @Column(name = "ubigeo", nullable = false)
    private String ubigeo;

    @ManyToOne
    @JoinColumn(name = "tipos_paciente_id", nullable = false)
    private TipoPacienteEntity tipoPacienteId;

    @Column(name = "estado_civil", nullable = false)
    private String estadoCivil;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "nombre_contacto", nullable = false)
    private String nombreContacto;

    @Column(name = "tipo_historia", nullable = false)
    private String tipoHistoria;

    @ManyToOne
    @JoinColumn(name = "aseguradora_id", nullable = false)
    private AseguradoraEntity aseguradoraId;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaEntity empresaId;

    @Email(message = "El email debe ser válido")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "foto_paciente", nullable = false)
    private String fotoPaciente;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "observacion", nullable = false)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "informacion_clinica_id", nullable = false)
    private InformacionClinicaEntity informacionClinicaId;

    @ManyToOne
    @JoinColumn(name = "estudio_id", nullable = false)
    private EstudioEntity estudioId;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private SedeEntity sedeId;

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