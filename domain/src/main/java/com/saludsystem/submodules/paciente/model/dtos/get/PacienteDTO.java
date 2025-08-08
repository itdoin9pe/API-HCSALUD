package com.saludsystem.submodules.paciente.model.dtos.get;

import com.saludsystem.submodules.paciente.model.vo.paciente.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PacienteDTO {

    private UUID pacienteId;

    @NotBlank(message = "El tipo documento no puede estar vacío")
    private String tipoDocumentoId;

    @NotBlank(message = "El número de documento no puede estar vacío")
    private String numeroDocumento;

    @NotBlank(message = "Los apellidos del paciente no pueden estar vacíos")
    private String apellidos;

    @NotBlank(message = "Los nombres del paciente no pueden estar vacíos")
    private String nombres;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaNacimiento;

    @Schema(description = "Edad (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer edad;

    @NotNull(message = "El estado no puede estar vacío")
    @Schema(description = "Estado del paciente (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer estado;

    private String ocupacion;

    private String direccion;

    @Schema(description = "ID del país (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Integer paisId;

    private String departamento;
    private String provincia;
    private String distrito;

    private String ubigeo;

    @NotNull(message = "El tipo de paciente no puede estar vacío")
    @Schema(description = "tipo paciente (0 = inactivo, 1 = activo)", example = "1", type = "integer")
    private Long tipoPacienteId;

    private String estadoCivil;

    private String sexo;

    private String nombreContacto;

    private String tipoHistoria;

    private UUID aseguradoraId;

    private UUID empresaId;

    @Email(message = "El email debe ser válido")
    private String email;

    private String fotoPaciente;

    private String titulo;

    private String observacion;

    private UUID informacionClinicaId;

    private UUID estudioId;

    private UUID sedeId;

    @NotBlank(message = "El número de celular no puede estar vacío")
    private String celular;

    public PacienteDTO(IdPaciente pacienteId, TipoDocumentoPaciente tipoDocumento, NumeroDocPaciente numeroDocumento,
                       ApellidoPaciente apellidos, NombrePaciente nombres, FNacimientoPaciente fechaNacimiento,
                       EdadPaciente edad, EstadoPaciente estado, OcupacionPaciente ocupacion,
                       DireccionPaciente direccion, IdPaisPaciente paisId, DepartamentoPaciente departamento,
                       ProvinciaPaciente provincia, DistritoPaciente distrito, UbigeoPaciente ubigeo,
                       IdTipoPaciente tipoPacienteId, EstadoCivilPaciente estadoCivil, SexoPaciente sexo,
                       NombreContactoPaciente nombreContacto, TipoHistoriaPaciente tipoHistoria,
                       IdAseguradoraPaciente aseguradoraId, IdEmpresaPaciente empresaId, EmailPaciente email,
                       FotoPaciente fotoPaciente, TituloPaciente titulo, ObservacionPaciente observacion,
                       InformacionClinicaPaciente informacionClinicaId, IdEstudioPaciente estudioId,
                       IdSedePaciente sedeId, CelularPaciente celular) {
        this.setPacienteId(pacienteId.value());
        this.setTipoDocumentoId(tipoDocumento.value());
        this.setNumeroDocumento(numeroDocumento.value());
        this.setApellidos(apellidos.value());
        this.setNombres(nombres.value());
        this.setFechaNacimiento(fechaNacimiento.value());
        this.setEdad(edad.value());
        this.setEstado(estado.value());
        this.setOcupacion(ocupacion.value());
        this.setDireccion(direccion.value());
        this.setPaisId(paisId.value());
        this.setDepartamento(departamento.value());
        this.setProvincia(provincia.value());
        this.setDistrito(distrito.value());
        this.setUbigeo(ubigeo.value());
        this.setTipoPacienteId(tipoPacienteId.value());
        this.setEstadoCivil(estadoCivil.value());
        this.setSexo(sexo.value());
        this.setNombreContacto(nombreContacto.value());
        this.setTipoHistoria(tipoHistoria.value());
        this.setAseguradoraId(aseguradoraId.value());
        this.setEmpresaId(empresaId.value());
        this.setEmail(email.email());
        this.setFotoPaciente(fotoPaciente.value());
        this.setTitulo(titulo.value());
        this.setObservacion(observacion.value());
        this.setInformacionClinicaId(informacionClinicaId.value());
        this.setEstudioId(estudioId.value());
        this.setSedeId(sedeId.value());
        this.setCelular(celular.value());
    }

}