package com.saludSystem.services.modules.Paciente.impl;

import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PaisRepository paisRepository;
    private final SedeRepository sedeRepository;
    private final EmpresaRepository empresaRepository;
    private final AseguradoraRepository aseguradoraRepository;
    private final EstudioRepository estudioRepository;
    private final TipoPacienteRepository tipoPacienteRepository;
    private final InformacionClinicaRepository informacionClinicaRepository;

    @Autowired
    public PacienteServiceImpl(
            PacienteRepository pacienteRepository, PaisRepository paisRepository,
            SedeRepository sedeRepository, EmpresaRepository empresaRepository,
            AseguradoraRepository aseguradoraRepository, EstudioRepository estudioRepository,
            TipoPacienteRepository tipoPacienteRepository, InformacionClinicaRepository informacionClinicaRepository)
    {
        this.pacienteRepository = pacienteRepository;
        this.paisRepository = paisRepository;
        this.sedeRepository = sedeRepository;
        this.empresaRepository = empresaRepository;
        this.aseguradoraRepository = aseguradoraRepository;
        this.estudioRepository = estudioRepository;
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.informacionClinicaRepository = informacionClinicaRepository;
    }

    @Override
    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO) {
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

        Optional<Pais> pais = paisRepository.findById(crearPacienteDTO.getPaisId());
        pais.ifPresent(paciente::setPaisId);

        paciente.setUbigeo(crearPacienteDTO.getUbigeo());

        Optional<TipoPaciente> tipoPaciente = tipoPacienteRepository.findById(crearPacienteDTO.getTipoPacienteId());
        tipoPaciente.ifPresent(paciente::setTipoPacienteId);

        paciente.setEstadoCivil(crearPacienteDTO.getEstadoCivil());
        paciente.setSexo(crearPacienteDTO.getSexo());
        paciente.setNombreContacto(crearPacienteDTO.getNombreContacto());
        paciente.setTipoHistoria(crearPacienteDTO.getTipoHistoria());

        Optional<Aseguradora> aseguradora = aseguradoraRepository.findById(crearPacienteDTO.getAseguradoraId());
        aseguradora.ifPresent(paciente::setAseguradoraId);

        Optional<Empresa> empresa = empresaRepository.findById(crearPacienteDTO.getEmpresaId());
        empresa.ifPresent(paciente::setEmpresaId);

        paciente.setEmail(crearPacienteDTO.getEmail());
        paciente.setFotoPaciente(crearPacienteDTO.getFotoPaciente());
        paciente.setTitulo(crearPacienteDTO.getTitulo());
        paciente.setObservacion(crearPacienteDTO.getObservacion());

        Optional<InformacionClinica> informacionClinica = informacionClinicaRepository.findById(crearPacienteDTO.getInformacionClinicaId());
        informacionClinica.ifPresent(paciente::setInformacionClinicaId);

        Optional<Estudio> estudio = estudioRepository.findById(crearPacienteDTO.getEstudioId());
        estudio.ifPresent(paciente::setEstudioId);

        Optional<Sede> sede = sedeRepository.findById(crearPacienteDTO.getSedeId());
        sede.ifPresent(paciente::setSedeId);

        paciente.setCelular(crearPacienteDTO.getCelular());

        return pacienteRepository.save(paciente);
    }

    @Override
    public Page<CrearPacienteDTO> getAllPacientes(Pageable pageable) {
        // Convierte entidades a DTOs para devolver al controlador
        return pacienteRepository.findAll(pageable)
                .map(paciente -> new CrearPacienteDTO());
    }

    private <T> T findEntityById(JpaRepository<T, Integer> repository, Integer id, String entityName) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(entityName + " no encontrado"));
    }

    public byte[] convertirBase64ABytes(String base64) {
        if (base64 == null || base64.isEmpty()) {
            throw new IllegalArgumentException("La cadena Base64 no puede ser nula o vacía");
        }
        return Base64.getDecoder().decode(base64);
    }

    private CrearPacienteDTO convertToDTO(Paciente paciente) {
        CrearPacienteDTO dto = new CrearPacienteDTO();

        dto.setTipoDocumentoId(paciente.getTipoDocumentoId());
        dto.setNumeroDocumento(paciente.getNumeroDocumento());
        dto.setApellidos(paciente.getApellidos());
        dto.setNombres(paciente.getNombres());
        dto.setFechaNacimiento(paciente.getFechaNacimiento());
        dto.setEdad(paciente.getEdad());
        dto.setEstado(paciente.getEstado());
        dto.setOcupacion(paciente.getOcupacion());
        dto.setDireccion(paciente.getDireccion());
        dto.setPaisId(paciente.getPaisId().getId());
        dto.setUbigeo(paciente.getUbigeo());
        dto.setTipoPacienteId(paciente.getTipoPacienteId().getTipoPacienteId());
        dto.setEstadoCivil(paciente.getEstadoCivil());
        dto.setSexo(paciente.getSexo());
        dto.setNombreContacto(paciente.getNombreContacto());
        dto.setTipoHistoria(paciente.getTipoHistoria());
        dto.setAseguradoraId(paciente.getAseguradoraId().getId());
        dto.setEmpresaId(paciente.getEmpresaId().getId());
        dto.setEmail(paciente.getEmail());
        dto.setFotoPaciente( paciente.getFotoPaciente());
        dto.setTitulo(paciente.getTitulo());
        dto.setObservacion(paciente.getObservacion());
        dto.setInformacionClinicaId(paciente.getInformacionClinicaId().getId());
        dto.setEstudioId(paciente.getEstudioId().getId());
        dto.setSedeId(paciente.getSedeId().getId());
        dto.setCelular(paciente.getCelular());

        return dto;
    }
}