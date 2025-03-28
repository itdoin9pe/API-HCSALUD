package com.saludSystem.Mantenimiento.Diagnostico.aplicacion.services.impl;

import com.saludSystem.Configuracion.Roles.aplicacion.services.RolePrefixResolver;
import com.saludSystem.Configuracion.Roles.dominio.RoleModel;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.aplicacion.services.AuthService;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.ActualizarDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.CrearDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.DiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.services.DiagnosticoService;
import com.saludSystem.Mantenimiento.Diagnostico.dominio.DiagnosticoModel;
import com.saludSystem.Mantenimiento.Diagnostico.infraestructura.repository.DiagnosticoRepository;
import com.saludSystem.Paciente.infraestructura.repositories.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    private final DiagnosticoRepository diagnosticoRepository;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final PacienteRepository pacienteRepository;
    private final RolePrefixResolver rolePrefixResolver;
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository, UserRepository userRepository, SysSaludRepository sysSaludRepository, PacienteRepository pacienteRepository, RolePrefixResolver rolePrefixResolver, AuthService authService, ModelMapper modelMapper) {
        this.diagnosticoRepository = diagnosticoRepository;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.pacienteRepository = pacienteRepository;
        this.rolePrefixResolver = rolePrefixResolver;
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveDiagnostico(CrearDiagnosticoDTO crearDiagnosticoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        DiagnosticoModel diagnosticoModel = new DiagnosticoModel();
        //Optional<PacienteModel> pacienteModel = pacienteRepository.findById(crearDiagnosticoDTO.getPacienteId());
        //pacienteModel.ifPresent(diagnosticoModel::setPacienteId);
        diagnosticoModel.setEnfermedadId(crearDiagnosticoDTO.getEnfermedadId());
        diagnosticoModel.setNombreEnfermedad(crearDiagnosticoDTO.getNombreEnfermedad());
        diagnosticoModel.setEstado(crearDiagnosticoDTO.getEstado());
        diagnosticoModel.setUser(userModel);
        diagnosticoModel.setHospital(hospital);
        diagnosticoRepository.save(diagnosticoModel);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public List<DiagnosticoDTO> getDiagnosticoList() {
        return diagnosticoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<DiagnosticoDTO> getAllDiagnostico(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<DiagnosticoModel> diagnosticoModelPage = diagnosticoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<DiagnosticoDTO> data = diagnosticoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, diagnosticoModelPage.getTotalElements(), diagnosticoModelPage.getTotalPages(), diagnosticoModelPage.getNumber() +1 );
    }

    @Override
    public ApiResponse updateDiagnostico(UUID diagnosticoId, ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        DiagnosticoModel diagnosticoModel = diagnosticoRepository.findById(diagnosticoId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        //Optional.ofNullable(actualizarDiagnosticoDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(diagnosticoModel::setPacienteId);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEnfermedadId()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoModel::setEnfermedadId);
        Optional.ofNullable(actualizarDiagnosticoDTO.getNombreEnfermedad()).filter(desc -> !desc.isBlank()).ifPresent(diagnosticoModel::setNombreEnfermedad);
        Optional.ofNullable(actualizarDiagnosticoDTO.getEstado()).ifPresent(diagnosticoModel::setEstado);
        diagnosticoRepository.save(diagnosticoModel);
        return new ApiResponse(true, "Diagnostico registrado correctamente");
    }

    @Override
    public DiagnosticoDTO getDiagnosticoById(UUID diagnosticoId) {
        DiagnosticoModel diagnosticoModel = diagnosticoRepository.findById(diagnosticoId).orElseThrow( () -> new ResourceNotFoundException("Diagnostico no encontrado"));
        return convertToDTO(diagnosticoModel);
    }

    @Override
    public ApiResponse deleteDiagnostico(UUID diagnosticoId) {
        diagnosticoRepository.deleteById(diagnosticoId);
        return new ApiResponse(true, "Diagnostico eliminado correctamente");
    }

    @Override
    public List<DiagnosticoDTO> getDiagnosticosFiltradosPorRol() {
        UserModel usuario = authService.getCurrentUser();
        RoleModel rol = usuario.getRol();
        String prefix = rolePrefixResolver.resolvePrefixFromRole(rol);
        if (prefix == null) {
            return List.of();
        }
        // Filtra por prefijo y por hospital del usuario
        List<DiagnosticoModel> diagnosticos = diagnosticoRepository.findByRolePrefixAndHospital(
                prefix + "-",
                usuario.getHospital().getHospitalId()
        );
        return diagnosticos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private DiagnosticoDTO convertToDTO(DiagnosticoModel diagnosticoModel) {
        return modelMapper.map(diagnosticoModel, DiagnosticoDTO.class);
    }

}