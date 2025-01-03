package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;

import com.saludSystem.entities.configuracion.InformacionClinica;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.TipoDocumento;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Configuration.TipoDocumentoRepository;
import com.saludSystem.repositories.modules.Generals.PaisRepository;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private SedeRepository sedeRepository;

    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO) {
        // Validar entidades relacionadas
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(crearPacienteDTO.getTipoDocumentoId())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de documento no válido"));

        Pais pais = paisRepository.findById(crearPacienteDTO.getPaisId())
                .orElseThrow(() -> new IllegalArgumentException("País no válido"));

        Sede sede = sedeRepository.findById(crearPacienteDTO.getSedeId())
                .orElseThrow(() -> new IllegalArgumentException("Sede no válida"));

        // Mapear DTO a entidad
        Paciente paciente = new Paciente();
        paciente.setTipoDocumento(tipoDocumento);
        paciente.setNumeroDocumento(crearPacienteDTO.getNumeroDocumento());
        paciente.setApellidos(crearPacienteDTO.getApellidos());
        paciente.setNombres(crearPacienteDTO.getNombres());
        paciente.setFechaNacimiento(crearPacienteDTO.getFechaNacimiento());
        paciente.setEdad(crearPacienteDTO.getEdad());
        paciente.setEstado(crearPacienteDTO.getEstado());
        paciente.setOcupacion(crearPacienteDTO.getOcupacion());
        paciente.setDireccion(crearPacienteDTO.getDireccion());
        paciente.setPais(pais);
        paciente.setUbigeo(crearPacienteDTO.getUbigeo());
        paciente.setTipoPacienteId(crearPacienteDTO.getTipoPacienteId());
        paciente.setEstadoCivil(crearPacienteDTO.getEstadoCivil());
        paciente.setSexo(crearPacienteDTO.getSexo());
        paciente.setNombreContacto(crearPacienteDTO.getNombreContacto());
        paciente.setTipoHistoria(crearPacienteDTO.getTipoHistoria());
        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setFotoPaciente(crearPacienteDTO.getFotoPaciente());
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());
        paciente.setSede(sede);
        paciente.setCelular(crearPacienteDTO.getCelular());

        // Asignar directamente las relaciones opcionales con IDs proporcionados
        if (crearPacienteDTO.getInformacionClinicaId() != null) {
            InformacionClinica informacionClinica = new InformacionClinica();
            informacionClinica.setId(crearPacienteDTO.getInformacionClinicaId());
            paciente.setInformacionClinica(informacionClinica);
        }

        if (crearPacienteDTO.getEstudioId() != null) {
            Estudio estudio = new Estudio();
            estudio.setId(crearPacienteDTO.getEstudioId());
            paciente.setEstudio(estudio);
        }

        if (crearPacienteDTO.getAseguradoraId() != null) {
            Aseguradora aseguradora = new Aseguradora();
            aseguradora.setId(crearPacienteDTO.getAseguradoraId());
            paciente.setAseguradora(aseguradora);
        }

        if (crearPacienteDTO.getEmpresaId() != null) {
            Empresa empresa = new Empresa();
            empresa.setId(crearPacienteDTO.getEmpresaId());
            paciente.setEmpresa(empresa);
        }


        return pacienteRepository.save(paciente);
    }
}
