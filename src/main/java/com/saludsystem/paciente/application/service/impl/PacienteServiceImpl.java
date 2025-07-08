package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.res.PacienteResponse;
import com.saludsystem.paciente.application.dto.req.PacienteRequest;
import com.saludsystem.paciente.application.dto.base.ActualizarPacienteDTO;
import com.saludsystem.paciente.application.service.PacienteService;
import com.saludsystem.configuracion.domain.model.SedeEntity;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.principal.domain.model.*;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.principal.infrastructure.adapters.out.persistance.*;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SedeRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public PacienteEntity savePaciente(PacienteRequest pacienteRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        PacienteEntity paciente = new PacienteEntity();
        paciente.setTipoDocumentoId(pacienteRequest.getTipoDocumentoId());
        paciente.setNumeroDocumento(pacienteRequest.getNumeroDocumento());
        paciente.setApellidos(pacienteRequest.getApellidos());
        paciente.setNombres(pacienteRequest.getNombres());
        paciente.setFechaNacimiento(pacienteRequest.getFechaNacimiento());
        paciente.setEdad(pacienteRequest.getEdad());
        paciente.setEstado(pacienteRequest.getEstado());
        paciente.setOcupacion(pacienteRequest.getOcupacion());
        paciente.setDireccion(pacienteRequest.getDireccion());
        Optional<PaisEntity> pais = paisRepository.findById(pacienteRequest.getPaisId());
        pais.ifPresent(paciente::setPaisId);
        paciente.setUbigeo(pacienteRequest.getUbigeo());
        Optional<TipoPacienteEntity> tipoPaciente = tipoPacienteRepository.findById(pacienteRequest.getTipoPacienteId());
        tipoPaciente.ifPresent(paciente::setTipoPacienteId);
        paciente.setEstadoCivil(pacienteRequest.getEstadoCivil());
        paciente.setSexo(pacienteRequest.getSexo());
        paciente.setNombreContacto(pacienteRequest.getNombreContacto());
        paciente.setTipoHistoria(pacienteRequest.getTipoHistoria());
        Optional<AseguradoraEntity> aseguradora = aseguradoraRepository.findById(pacienteRequest.getAseguradoraId());
        aseguradora.ifPresent(paciente::setAseguradoraId);
        Optional<EmpresaEntity> empresa = empresaRepository.findById(pacienteRequest.getEmpresaId());
        empresa.ifPresent(paciente::setEmpresaId);
        paciente.setEmail(pacienteRequest.getEmail());
        paciente.setFotoPaciente(pacienteRequest.getFotoPaciente());
        paciente.setTitulo(pacienteRequest.getTitulo());
        paciente.setObservacion(pacienteRequest.getObservacion());
        Optional<InformacionClinicaEntity> informacionClinica = informacionClinicaRepository.findById(pacienteRequest.getInformacionClinicaId());
        informacionClinica.ifPresent(paciente::setInformacionClinicaId);
        Optional<EstudioEntity> estudio = estudioRepository.findById(pacienteRequest.getEstudioId());
        estudio.ifPresent(paciente::setEstudioId);
        Optional<SedeEntity> sede = sedeRepository.findById(pacienteRequest.getSedeId());
        sede.ifPresent(paciente::setSedeId);
        paciente.setCelular(pacienteRequest.getCelular());
        paciente.setHospital(hospital);
        paciente.setUser(user);
        return pacienteRepository.save(paciente);
    }

    @Override
    public ActualizarPacienteDTO updatePaciente(UUID pacienteId, ActualizarPacienteDTO actualizarPacienteDTO) {
        PacienteEntity paciente = pacienteRepository.findById(pacienteId).orElseThrow(
                () -> new ResourceNotFoundException("Paciente no encontrado con ID"));
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
        Optional.ofNullable(actualizarPacienteDTO.getPaisId()).flatMap(paisRepository::findById).ifPresent(paciente::setPaisId);
        Optional.ofNullable(actualizarPacienteDTO.getTipoPacienteId()).flatMap(tipoPacienteRepository::findById).ifPresent(paciente::setTipoPacienteId);
        Optional.ofNullable(actualizarPacienteDTO.getAseguradoraId()).flatMap(aseguradoraRepository::findById).ifPresent(paciente::setAseguradoraId);
        Optional.ofNullable(actualizarPacienteDTO.getEmpresaId()).flatMap(empresaRepository::findById).ifPresent(paciente::setEmpresaId);
        Optional.ofNullable(actualizarPacienteDTO.getInformacionClinicaId()).flatMap(informacionClinicaRepository::findById).ifPresent(paciente::setInformacionClinicaId);
        Optional.ofNullable(actualizarPacienteDTO.getEstudioId()).flatMap(estudioRepository::findById).ifPresent(paciente::setEstudioId);
        Optional.ofNullable(actualizarPacienteDTO.getSedeId()).flatMap(sedeRepository::findById).ifPresent(paciente::setSedeId);
        pacienteRepository.save(paciente);
        return modelMapper.map(paciente, ActualizarPacienteDTO.class);
    }

    @Override
    public Optional<PacienteResponse> getPacienteById(UUID pacienteId) {
        return Optional.ofNullable(pacienteRepository.findById(pacienteId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado")));
    }

    @Override
    public List<PacienteResponse> getPacienteList() {
        return pacienteRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<PacienteResponse> getAllPaciente(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PacienteEntity> pacienteModelPage = pacienteRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<PacienteResponse> data = pacienteModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, pacienteModelPage.getTotalElements(), pacienteModelPage.getTotalPages(), pacienteModelPage.getNumber() + 1);
    }

    @Override
    public ApiResponse deletePaciente(UUID pacienteId) {
        pacienteRepository.deleteById(pacienteId);
        return new ApiResponse(true, "Paciente eliminado correctamente");
    }

    private PacienteResponse convertToDTO(PacienteEntity paciente) {
        return modelMapper.map(paciente, PacienteResponse.class);
    }

}