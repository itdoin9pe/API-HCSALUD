package com.saludSystem.services.modules.Paciente.impl;

import com.saludSystem.dtos.Generals.Aseguradora.AseguradoraDTO;
import com.saludSystem.dtos.Paciente.ActualizarPacienteDTO;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.dtos.Paciente.PacienteDTO;
import com.saludSystem.entities.*;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    private final ModelMapper modelMapper;

    @Autowired
    public PacienteServiceImpl(
            PacienteRepository pacienteRepository, PaisRepository paisRepository,
            SedeRepository sedeRepository, EmpresaRepository empresaRepository,
            AseguradoraRepository aseguradoraRepository, EstudioRepository estudioRepository,
            TipoPacienteRepository tipoPacienteRepository, InformacionClinicaRepository informacionClinicaRepository,
            ModelMapper modelMapper
    )
    {
        this.pacienteRepository = pacienteRepository;
        this.paisRepository = paisRepository;
        this.sedeRepository = sedeRepository;
        this.empresaRepository = empresaRepository;
        this.aseguradoraRepository = aseguradoraRepository;
        this.estudioRepository = estudioRepository;
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.modelMapper = modelMapper;
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
    public ActualizarPacienteDTO updatePaciente(UUID pacienteId,ActualizarPacienteDTO actualizarPacienteDTO) {
        Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrado con ID" + pacienteId));
        Optional.ofNullable(actualizarPacienteDTO.getTipoDocumentoId()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTipoDocumentoId);
        Optional.ofNullable(actualizarPacienteDTO.getNumeroDocumento()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNumeroDocumento);
        Optional.ofNullable(actualizarPacienteDTO.getApellidos()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setApellidos);
        Optional.ofNullable(actualizarPacienteDTO.getNombres()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNombres);
        Optional.ofNullable(actualizarPacienteDTO.getFechaNacimiento()).ifPresent(paciente::setFechaNacimiento);
        Optional.ofNullable(actualizarPacienteDTO.getEdad()).ifPresent(paciente::setEdad);
        Optional.ofNullable(actualizarPacienteDTO.getEstado()).ifPresent(paciente::setEstado);
        Optional.ofNullable(actualizarPacienteDTO.getOcupacion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setOcupacion);
        Optional.ofNullable(actualizarPacienteDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setDireccion);
        Optional.ofNullable(actualizarPacienteDTO.getUbigeo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setUbigeo);
        Optional.ofNullable(actualizarPacienteDTO.getEstadoCivil()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setEstadoCivil);
        Optional.ofNullable(actualizarPacienteDTO.getSexo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setSexo);
        Optional.ofNullable(actualizarPacienteDTO.getNombreContacto()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setNombreContacto);
        Optional.ofNullable(actualizarPacienteDTO.getTipoHistoria()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTipoHistoria);
        Optional.ofNullable(actualizarPacienteDTO.getEmail()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setEmail);
        Optional.ofNullable(actualizarPacienteDTO.getTitulo()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setTitulo);
        Optional.ofNullable(actualizarPacienteDTO.getObservacion()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setObservacion);
        Optional.ofNullable(actualizarPacienteDTO.getCelular()).filter(desc -> !desc.isBlank()).ifPresent(paciente::setCelular);

        Optional.ofNullable(actualizarPacienteDTO.getPaisId())
                .flatMap(paisRepository::findById)
                .ifPresent(paciente::setPaisId);

        Optional.ofNullable(actualizarPacienteDTO.getTipoPacienteId())
                .flatMap(tipoPacienteRepository::findById)
                .ifPresent(paciente::setTipoPacienteId);

        Optional.ofNullable(actualizarPacienteDTO.getAseguradoraId())
                .flatMap(aseguradoraRepository::findById)
                .ifPresent(paciente::setAseguradoraId);

        Optional.ofNullable(actualizarPacienteDTO.getEmpresaId())
                .flatMap(empresaRepository::findById)
                .ifPresent(paciente::setEmpresaId);

        Optional.ofNullable(actualizarPacienteDTO.getInformacionClinicaId())
                .flatMap(informacionClinicaRepository::findById)
                .ifPresent(paciente::setInformacionClinicaId);

        Optional.ofNullable(actualizarPacienteDTO.getEstudioId())
                .flatMap(estudioRepository::findById)
                .ifPresent(paciente::setEstudioId);

        Optional.ofNullable(actualizarPacienteDTO.getSedeId())
                .flatMap(sedeRepository::findById)
                .ifPresent(paciente::setSedeId);
        pacienteRepository.save(paciente);
        return modelMapper.map(paciente, ActualizarPacienteDTO.class);
    }

    @Override
    public Optional<PacienteDTO> getPacienteById(UUID pacienteId) {
        return Optional.ofNullable(pacienteRepository.findById(pacienteId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado con ID: " + pacienteId)));
    }

    @Override
    public List<PacienteDTO> getPacienteList() {
        return pacienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePaciente(UUID pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + pacienteId));
        pacienteRepository.delete(paciente);
    }

    @Override
    public List<PacienteDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Paciente> pacientePage = pacienteRepository.findAll(pageable);
        return pacientePage.getContent().stream()
                .map(paciente -> modelMapper.map(paciente,PacienteDTO.class))
                .toList();
    }

    @Override
    public long getTotalCount() {
        return pacienteRepository.count();
    }

    private PacienteDTO convertToDTO(Paciente paciente) {
        return modelMapper.map(paciente, PacienteDTO.class);
    }
}