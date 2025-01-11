package com.saludSystem.services.modules.Paciente;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private AseguradoraRepository aseguradoraRepository;

    @Autowired
    private EstudioRepository estudioRepository;

    @Autowired
    private TipoPacienteRepository tipoPacienteRepository;

    @Autowired
    private InformacionClinicaRepository informacionClinicaRepository;

    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO, String fotoPacienteBase64) {

        byte[] fotoPaciente = convertirBase64ABytes(fotoPacienteBase64);

        String fotoPacienteBase64String = Base64.getEncoder().encodeToString(fotoPaciente);

        Paciente paciente = new Paciente();
        paciente.setTipoDocumentoId(crearPacienteDTO.getTipoDocumentoId());
        paciente.setNumeroDocumento(crearPacienteDTO.getNumeroDocumento());
        paciente.setApellidos(crearPacienteDTO.getApellidos());
        paciente.setNombres(crearPacienteDTO.getNombres());
        paciente.setFechaNacimiento(crearPacienteDTO.getFechaNacimiento());
        paciente.setEdad(crearPacienteDTO.getEdad());
        paciente.setEstado(crearPacienteDTO.getEstado());
        paciente.setOcupacion(crearPacienteDTO.getOcupacion());
        paciente.setDireccion(crearPacienteDTO.getDireccion());
        paciente.setCelular(crearPacienteDTO.getCelular());
        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setTipoHistoria(crearPacienteDTO.getTipoHistoria());
        paciente.setUbigeo(crearPacienteDTO.getUbigeo());
        paciente.setNombreContacto(crearPacienteDTO.getNombreContacto());
        paciente.setEstadoCivil(crearPacienteDTO.getEstadoCivil());
        paciente.setSexo(crearPacienteDTO.getSexo());

        paciente.setFotoPaciente(fotoPacienteBase64);

        //paciente.setFotoPaciente(crearPacienteDTO.getFotoPaciente());
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());

        Pais pais = paisRepository.findById(crearPacienteDTO.getPaisId()).orElseThrow(() -> new RuntimeException("País no encontrado"));
        paciente.setPaisId(pais);

        Sede sede = sedeRepository.findById(crearPacienteDTO.getSedeId()).orElseThrow(() -> new RuntimeException("Sede no encontrada"));
        paciente.setSedeId(sede);

        Empresa empresa = empresaRepository.findById(crearPacienteDTO.getEmpresaId()).orElseThrow(() ->new RuntimeException("Empresa no encontrada"));
        paciente.setEmpresaId(empresa);

        Aseguradora aseguradora =  aseguradoraRepository.findById(crearPacienteDTO.getAseguradoraId()).orElseThrow(() -> new RuntimeException("Aseguradora no encontrada"));
        paciente.setAseguradoraId(aseguradora);

        Estudio estudio = estudioRepository.findById(crearPacienteDTO.getEstudioId()).orElseThrow(() -> new RuntimeException("Estudio no encontrado"));
        paciente.setEstudioId(estudio);

        TipoPaciente tipoPaciente = tipoPacienteRepository.findById(crearPacienteDTO.getTipoPacienteId()).orElseThrow(() -> new RuntimeException("Tipo de Paciente no encontrado"));
        paciente.setTipoPacienteId(tipoPaciente);

        InformacionClinica informacionClinica = informacionClinicaRepository.findById(crearPacienteDTO.getInformacionClinicaId()).orElseThrow(() -> new RuntimeException("Informacion de la Clinica no encontrada"));
        paciente.setInformacionClinicaId(informacionClinica);

        //paciente.setFotoPaciente(fotoPaciente);

        return pacienteRepository.save(paciente);
    }

    // Nuevo método para obtener todos los pacientes
    public List<CrearPacienteDTO> getAllPacientes() {
        return pacienteRepository.findAll().
                stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public byte[] convertirBase64ABytes(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    // Conversión de entidad a DTO
    private CrearPacienteDTO convertToDTO(Paciente paciente) {
        CrearPacienteDTO crearPacienteDTO = new CrearPacienteDTO();
        crearPacienteDTO.setTipoDocumentoId(paciente.getTipoDocumentoId());
        crearPacienteDTO.setNumeroDocumento(paciente.getNumeroDocumento());
        crearPacienteDTO.setApellidos(paciente.getApellidos());
        crearPacienteDTO.setNombres(paciente.getNombres());
        crearPacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        crearPacienteDTO.setEdad(paciente.getEdad());
        crearPacienteDTO.setEstado(paciente.getEstado());
        crearPacienteDTO.setOcupacion(paciente.getOcupacion());
        crearPacienteDTO.setDireccion(paciente.getDireccion());
        crearPacienteDTO.setPaisId(crearPacienteDTO.getPaisId());
        crearPacienteDTO.setUbigeo(paciente.getUbigeo());
        crearPacienteDTO.setTipoPacienteId(paciente.getTipoPacienteId().getTipoPacienteId());
        crearPacienteDTO.setEstadoCivil(paciente.getEstadoCivil());
        crearPacienteDTO.setSexo(paciente.getSexo());
        crearPacienteDTO.setNombreContacto(paciente.getNombreContacto());
        crearPacienteDTO.setTipoHistoria(paciente.getTipoHistoria());
        crearPacienteDTO.setAseguradoraId(paciente.getAseguradoraId().getId());
        crearPacienteDTO.setEmpresaId(paciente.getEmpresaId().getId());
        crearPacienteDTO.setEmail(paciente.getEmail());
        crearPacienteDTO.setFotoPaciente(paciente.getFotoPaciente());
        crearPacienteDTO.setTitulo(paciente.getTitulo());
        crearPacienteDTO.setObservacion(paciente.getObservacion());
        crearPacienteDTO.setInformacionClinicaId(paciente.getInformacionClinicaId().getId());
        crearPacienteDTO.setEstudioId(paciente.getEstudioId().getId());
        crearPacienteDTO.setSedeId(paciente.getSedeId().getId());
        crearPacienteDTO.setCelular(paciente.getCelular());
        return crearPacienteDTO;
    }

}