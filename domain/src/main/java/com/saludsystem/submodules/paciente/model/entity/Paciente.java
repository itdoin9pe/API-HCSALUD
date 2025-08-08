package com.saludsystem.submodules.paciente.model.entity;

import com.saludsystem.submodules.paciente.model.vo.paciente.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Paciente {

    private final IdPaciente pacienteId;
    private final TipoDocumentoPaciente tipoDocumento;
    private final NumeroDocPaciente numeroDocumento;
    private final ApellidoPaciente apellidos;
    private final NombrePaciente nombres;
    private final FNacimientoPaciente fechaNacimiento;
    private final EdadPaciente edad;
    private final EstadoPaciente estado;
    private final OcupacionPaciente ocupacion;
    private final DireccionPaciente direccion;
    private final IdPaisPaciente paisId;
    private final DepartamentoPaciente departamento;
    private final ProvinciaPaciente provincia;
    private final DistritoPaciente distrito;
    private final UbigeoPaciente ubigeo;
    private final IdTipoPaciente tipoPacienteId;
    private final EstadoCivilPaciente estadoCivil;
    private final SexoPaciente sexo;
    private final NombreContactoPaciente nombreContacto;
    private final TipoHistoriaPaciente tipoHistoria;
    private final IdAseguradoraPaciente aseguradoraId;
    private final IdEmpresaPaciente empresaId;
    private final EmailPaciente email;
    private final FotoPaciente fotoPaciente;
    private final TituloPaciente titulo;
    private final ObservacionPaciente observacion;
    private final InformacionClinicaPaciente informacionClinicaId;
    private final IdEstudioPaciente estudioId;
    private final IdSedePaciente sedeId;
    private final CelularPaciente celular;

}
