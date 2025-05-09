package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.AntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearAntecedenteDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarAntecedenteDTO;
import com.saludSystem.application.services.Paciente.HistorialClinico.AntecedenteService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.HistorialClinico.AntecedentesEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.AntecedenteRespository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
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
public class AntecedenteServiceImpl implements AntecedenteService {

    private final AntecedenteRespository antecedenteRespository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public AntecedenteServiceImpl(AntecedenteRespository antecedenteRespository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.antecedenteRespository = antecedenteRespository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAntecedentes(CrearAntecedenteDTO crearAntecedenteDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AntecedentesEntity antecedentesEntity = new AntecedentesEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearAntecedenteDTO.getPacienteId());
        pacienteEntity.ifPresent(antecedentesEntity::setPacienteEntity);
        antecedentesEntity.setMotivo(crearAntecedenteDTO.getMotivo());
        antecedentesEntity.setEnfermedad(crearAntecedenteDTO.getEnfermedad());
        antecedentesEntity.setTiempoEnfermedad(crearAntecedenteDTO.getTiempoEnfermedad());
        antecedentesEntity.setSigno(crearAntecedenteDTO.getSigno());
        antecedentesEntity.setRelato(crearAntecedenteDTO.getRelato());
        antecedentesEntity.setFunciones(crearAntecedenteDTO.getFunciones());
        antecedentesEntity.setAntecedentesPersonales(crearAntecedenteDTO.getAntecedentesPersonales());
        antecedentesEntity.setAntecedentesFamiliares(crearAntecedenteDTO.getAntecedentesFamiliares());
        antecedentesEntity.setMedicamento(crearAntecedenteDTO.getMedicamento());
        antecedentesEntity.setNombreMedicamento(crearAntecedenteDTO.getNombreMedicamento());
        antecedentesEntity.setMotivoMedicamento(crearAntecedenteDTO.getMotivoMedicamento());
        antecedentesEntity.setDosis(crearAntecedenteDTO.getDosis());
        antecedentesEntity.setHospital(hospital);
        antecedentesEntity.setUser(user);
        antecedenteRespository.save(antecedentesEntity);
        return new ApiResponse(true, "Antecedente creado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAntecentes(UUID antecedenteId, ActualizarAntecedenteDTO actualizarAntecedenteDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AntecedentesEntity antecedentesEntity = antecedenteRespository.findById(antecedenteId).orElseThrow(
                () -> new ResourceNotFoundException("Antecedente no encontrad"));
        Optional.ofNullable(actualizarAntecedenteDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(antecedentesEntity::setPacienteEntity);
        Optional.ofNullable(actualizarAntecedenteDTO.getMotivo()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setMotivo);
        Optional.ofNullable(actualizarAntecedenteDTO.getEnfermedad()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setEnfermedad);
        Optional.ofNullable(actualizarAntecedenteDTO.getTiempoEnfermedad()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setTiempoEnfermedad);
        Optional.ofNullable(actualizarAntecedenteDTO.getSigno()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setSigno);
        Optional.ofNullable(actualizarAntecedenteDTO.getFunciones()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setFunciones);
        Optional.ofNullable(actualizarAntecedenteDTO.getAntecedentesPersonales()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setAntecedentesPersonales);
        Optional.ofNullable(actualizarAntecedenteDTO.getAntecedentesFamiliares()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setAntecedentesFamiliares);
        Optional.ofNullable(actualizarAntecedenteDTO.getMedicamento()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setMedicamento);
        Optional.ofNullable(actualizarAntecedenteDTO.getNombreMedicamento()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setNombreMedicamento);
        Optional.ofNullable(actualizarAntecedenteDTO.getMotivoMedicamento()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setMotivoMedicamento);
        Optional.ofNullable(actualizarAntecedenteDTO.getDosis()).filter(desc -> !desc.isBlank()).ifPresent(antecedentesEntity::setDosis);
        antecedenteRespository.save(antecedentesEntity);
        return new ApiResponse(true, "Antecedente actualizado correctamente");
    }

    @Override
    public AntecedenteDTO getAntecedenteById(UUID antecedenteId) {
        AntecedentesEntity antecedentesEntity = antecedenteRespository.findById(antecedenteId).orElseThrow(
                () -> new ResourceNotFoundException("Antecedente no encontrad"));
        return convertToDTO(antecedentesEntity);
    }

    @Override
    public ListResponse<AntecedenteDTO> getAllAntecedentes(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AntecedentesEntity> antecedentesEntityPage = antecedenteRespository.findByHospital_HospitalId(hospitalId, pageable);
        List<AntecedenteDTO> data = antecedentesEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, antecedentesEntityPage.getTotalElements(), antecedentesEntityPage.getTotalPages(), antecedentesEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteAntecedente(UUID antecedenteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        antecedenteRespository.deleteById(antecedenteId);
        return new ApiResponse(true, "Antecedente eliminado correctamente");
    }

    private AntecedenteDTO convertToDTO(AntecedentesEntity antecedentesEntity) {
        return modelMapper.map(antecedentesEntity, AntecedenteDTO.class);
    }

}