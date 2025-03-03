package com.saludSystem.application.services.modules.Paciente.impl;
/*
import com.saludSystem.dtos.Paciente.ActualizarPacienteDTO;
import com.saludSystem.dtos.Paciente.CrearPacienteDTO;
import com.saludSystem.dtos.Paciente.PacienteDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.entities.*;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.entities.configuracion.SysSalud;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.UserRepository;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.repositories.modules.Generals.*;
import com.saludSystem.repositories.modules.Paciente.PacienteRepository;
import com.saludSystem.services.modules.Paciente.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, PaisRepository paisRepository, SedeRepository sedeRepository, EmpresaRepository empresaRepository, AseguradoraRepository aseguradoraRepository, EstudioRepository estudioRepository, TipoPacienteRepository tipoPacienteRepository, InformacionClinicaRepository informacionClinicaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.paisRepository = paisRepository;
        this.sedeRepository = sedeRepository;
        this.empresaRepository = empresaRepository;
        this.aseguradoraRepository = aseguradoraRepository;
        this.estudioRepository = estudioRepository;
        this.tipoPacienteRepository = tipoPacienteRepository;
        this.informacionClinicaRepository = informacionClinicaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Paciente savePaciente(CrearPacienteDTO crearPacienteDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
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
        paciente.setHospital(hospital);
        paciente.setUser(user);
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
    public ListResponse<PacienteDTO> getAllPaciente(UUID hospitalId, int page, int rows) {
        List<Paciente> pacientes = pacienteRepository.findByHospital_HospitalId(hospitalId);
        List<PacienteDTO> data = pacientes.stream().map(paciente -> {
            PacienteDTO dto = new PacienteDTO();
            dto.setPacienteId(paciente.getPacienteId());
            dto.setTipoDocumentoId(paciente.getTipoDocumentoId());
            dto.setNumeroDocumento(paciente.getNumeroDocumento());
            dto.setApellidos(paciente.getApellidos());
            dto.setNombres(paciente.getNombres());
            dto.setFechaNacimiento(paciente.getFechaNacimiento());
            dto.setEdad(paciente.getEdad());
            dto.setEstado(paciente.getEstado());
            dto.setOcupacion(paciente.getOcupacion());
            dto.setDireccion(paciente.getDireccion());
            dto.setPaisId(paciente.getPaisId() != null ? paciente.getPaisId().getId() : null);
            dto.setUbigeo(paciente.getUbigeo());
            dto.setTipoPacienteId(paciente.getTipoPacienteId() != null ? paciente.getTipoPacienteId().getTipoPacienteId() : null);
            dto.setEstadoCivil(paciente.getEstadoCivil());
            dto.setSexo(paciente.getSexo());
            dto.setNombreContacto(paciente.getNombreContacto());
            dto.setTipoHistoria(paciente.getTipoHistoria());
            dto.setAseguradoraId(paciente.getAseguradoraId() != null ? paciente.getAseguradoraId().getAseguradoraId() : null);
            dto.setEmpresaId(paciente.getEmpresaId() != null ? paciente.getEmpresaId().getEmpresaId() : null);
            dto.setEmail(paciente.getEmail());
            dto.setFotoPaciente(paciente.getFotoPaciente());
            dto.setTitulo(paciente.getTitulo());
            dto.setObservacion(paciente.getObservacion());
            dto.setInformacionClinicaId(paciente.getInformacionClinicaId() != null ? paciente.getInformacionClinicaId().getInformacionClinicaId() : null);
            dto.setEstudioId(paciente.getEstudioId() != null ? paciente.getEstudioId().getEstudioId() : null);
            dto.setSedeId(paciente.getSedeId() != null ? paciente.getSedeId().getSedeId() : null);
            dto.setCelular(paciente.getCelular());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public ApiResponse deletePaciente(UUID pacienteId) {
        pacienteRepository.deleteById(pacienteId);
        return new ApiResponse(true, "Paciente eliminado correctamente");
    }

    private PacienteDTO convertToDTO(Paciente paciente) {
        return modelMapper.map(paciente, PacienteDTO.class);
    }

}

 */