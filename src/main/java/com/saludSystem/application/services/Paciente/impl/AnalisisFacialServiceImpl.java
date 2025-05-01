package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.GET.AnalisisGeneralDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearAnalisisFacialDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarAnalisisFacialDTO;
import com.saludSystem.application.services.Paciente.AnalisisFacialService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.AnalisisFacialEntity;
import com.saludSystem.domain.model.Paciente.AnalisisGeneralEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.AnalisisFacialRepository;
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
public class AnalisisFacialServiceImpl implements AnalisisFacialService {

    private final AnalisisFacialRepository analisisFacialRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public AnalisisFacialServiceImpl(AnalisisFacialRepository analisisFacialRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, PacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.analisisFacialRepository = analisisFacialRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveAnalisisFacil(CrearAnalisisFacialDTO crearAnalisisFacialDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisFacialEntity analisisFacialEntity = new AnalisisFacialEntity();
        PacienteEntity paciente = pacienteRepository.findById(crearAnalisisFacialDTO.getPacienteId())
                .orElseThrow(() -> new IllegalArgumentException("Paciente no encontrado con ID: " + crearAnalisisFacialDTO.getPacienteId()));
        analisisFacialEntity.setTipoFacial(crearAnalisisFacialDTO.getTipoFacial());
        analisisFacialEntity.setConvexion(crearAnalisisFacialDTO.getConvexion());
        analisisFacialEntity.setTerciosFaciales(crearAnalisisFacialDTO.getTerciosFaciales());
        analisisFacialEntity.setSuperior(crearAnalisisFacialDTO.getSuperior());
        analisisFacialEntity.setInferior(crearAnalisisFacialDTO.getInferior());
        analisisFacialEntity.setMedio(crearAnalisisFacialDTO.getMedio());
        analisisFacialEntity.setSeladoLabial(crearAnalisisFacialDTO.getSeladoLabial());
        analisisFacialEntity.setRelacionLabios(crearAnalisisFacialDTO.getRelacionLabios());
        analisisFacialEntity.setSimetriaFacial(crearAnalisisFacialDTO.getSimetriaFacial());
        analisisFacialEntity.setSimetriaDerecho(crearAnalisisFacialDTO.getSimetriaDerecho());
        analisisFacialEntity.setSimetriaIzquierdo(crearAnalisisFacialDTO.getSimetriaIzquierdo());
        analisisFacialEntity.setSimetriaFacialApertura(crearAnalisisFacialDTO.getSimetriaFacialApertura());
        analisisFacialEntity.setSimetriaAperturaDerecho(crearAnalisisFacialDTO.getSimetriaAperturaDerecho());
        analisisFacialEntity.setSimetriaAperturaIzquierdo(crearAnalisisFacialDTO.getSimetriaAperturaIzquierdo());
        analisisFacialEntity.setAnguloMasoLabial(crearAnalisisFacialDTO.getAnguloMasoLabial());
        analisisFacialEntity.setSurcoMentoLabial(crearAnalisisFacialDTO.getSurcoMentoLabial());
        analisisFacialEntity.setProyeccionSigomatica(crearAnalisisFacialDTO.getProyeccionSigomatica());
        analisisFacialEntity.setLineaMenton(crearAnalisisFacialDTO.getLineaMenton());
        analisisFacialEntity.setAnguloMenton(crearAnalisisFacialDTO.getAnguloMenton());
        analisisFacialEntity.setPatron1(crearAnalisisFacialDTO.getPatron1());
        analisisFacialEntity.setRetrusionMandibular(crearAnalisisFacialDTO.getRetrusionMandibular());
        analisisFacialEntity.setProtusionMaxilar(crearAnalisisFacialDTO.getProtusionMaxilar());
        analisisFacialEntity.setPatron3(crearAnalisisFacialDTO.getPatron3());
        analisisFacialEntity.setProtusion2Mandibular(crearAnalisisFacialDTO.getProtusion2Mandibular());
        analisisFacialEntity.setRetrusion2Maxilar(crearAnalisisFacialDTO.getRetrusion2Maxilar());
        analisisFacialEntity.setCaraCorta(crearAnalisisFacialDTO.getCaraCorta());
        analisisFacialRepository.save(analisisFacialEntity);
        return new ApiResponse(true, "Analisis facial creado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateAnalisisFacial(UUID pacienteAnalisisFacialId, ActualizarAnalisisFacialDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        AnalisisFacialEntity entity = analisisFacialRepository.findById(pacienteAnalisisFacialId)
                .orElseThrow(() -> new ResourceNotFoundException("Registro de análisis facial no encontrado"));
        Optional.ofNullable(dto.getPacienteId()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getTipoFacial()).filter(v -> !v.isBlank()).ifPresent(entity::setTipoFacial);
        Optional.ofNullable(dto.getConvexion()).filter(v -> !v.isBlank()).ifPresent(entity::setConvexion);
        Optional.ofNullable(dto.getTerciosFaciales()).filter(v -> !v.isBlank()).ifPresent(entity::setTerciosFaciales);
        Optional.ofNullable(dto.getSuperior()).filter(v -> !v.isBlank()).ifPresent(entity::setSuperior);
        Optional.ofNullable(dto.getMedio()).filter(v -> !v.isBlank()).ifPresent(entity::setMedio);
        Optional.ofNullable(dto.getInferior()).filter(v -> !v.isBlank()).ifPresent(entity::setInferior);
        Optional.ofNullable(dto.getSeladoLabial()).filter(v -> !v.isBlank()).ifPresent(entity::setSeladoLabial);
        Optional.ofNullable(dto.getRelacionLabios()).filter(v -> !v.isBlank()).ifPresent(entity::setRelacionLabios);
        Optional.ofNullable(dto.getSimetriaFacial()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaFacial);
        Optional.ofNullable(dto.getSimetriaDerecho()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaDerecho);
        Optional.ofNullable(dto.getSimetriaIzquierdo()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaIzquierdo);
        Optional.ofNullable(dto.getSimetriaFacialApertura()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaFacialApertura);
        Optional.ofNullable(dto.getSimetriaAperturaDerecho()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaAperturaDerecho);
        Optional.ofNullable(dto.getSimetriaAperturaIzquierdo()).filter(v -> !v.isBlank()).ifPresent(entity::setSimetriaAperturaIzquierdo);
        Optional.ofNullable(dto.getAnguloMasoLabial()).filter(v -> !v.isBlank()).ifPresent(entity::setAnguloMasoLabial);
        Optional.ofNullable(dto.getSurcoMentoLabial()).filter(v -> !v.isBlank()).ifPresent(entity::setSurcoMentoLabial);
        Optional.ofNullable(dto.getProyeccionSigomatica()).filter(v -> !v.isBlank()).ifPresent(entity::setProyeccionSigomatica);
        Optional.ofNullable(dto.getLineaMenton()).filter(v -> !v.isBlank()).ifPresent(entity::setLineaMenton);
        Optional.ofNullable(dto.getAnguloMenton()).filter(v -> !v.isBlank()).ifPresent(entity::setAnguloMenton);
        Optional.ofNullable(dto.getPatron1()).filter(v -> !v.isBlank()).ifPresent(entity::setPatron1);
        Optional.ofNullable(dto.getRetrusionMandibular()).filter(v -> !v.isBlank()).ifPresent(entity::setRetrusionMandibular);
        Optional.ofNullable(dto.getProtusionMaxilar()).filter(v -> !v.isBlank()).ifPresent(entity::setProtusionMaxilar);
        Optional.ofNullable(dto.getPatron3()).filter(v -> !v.isBlank()).ifPresent(entity::setPatron3);
        Optional.ofNullable(dto.getProtusion2Mandibular()).filter(v -> !v.isBlank()).ifPresent(entity::setProtusion2Mandibular);
        Optional.ofNullable(dto.getRetrusion2Maxilar()).filter(v -> !v.isBlank()).ifPresent(entity::setRetrusion2Maxilar);
        Optional.ofNullable(dto.getCaraCorta()).filter(v -> !v.isBlank()).ifPresent(entity::setCaraCorta);
        analisisFacialRepository.save(entity);
        return new ApiResponse(true, "Análisis facial actualizado correctamente");
    }


    @Override
    public ListResponse<AnalisisFacialDTO> getAllAnalisisFacial(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AnalisisFacialEntity> analisisFacialEntityPage = analisisFacialRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AnalisisFacialDTO> data = analisisFacialEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, analisisFacialEntityPage.getTotalElements(), analisisFacialEntityPage.getTotalPages(), analisisFacialEntityPage.getNumber() + 1);
    }

    @Override
    public AnalisisFacialDTO getAnalisisFacialById(UUID pacienteAnalisisFacialId) {
        AnalisisFacialEntity analisisFacialEntity = analisisFacialRepository.findById(pacienteAnalisisFacialId).orElseThrow(
                () -> new ResourceNotFoundException("Reistro de Analisis facial no encontrado correctamente"));
        return convertToDTO(analisisFacialEntity);
    }

    @Override
    public ApiResponse deleteAnalisisFacial(UUID pacienteAnalisisFacialId) {
        analisisFacialRepository.deleteById(pacienteAnalisisFacialId);
        return new ApiResponse(true, "Analisis facial eliminado corectamente");
    }

    private AnalisisFacialDTO convertToDTO(AnalisisFacialEntity analisisFacialEntity) {
        return modelMapper.map(analisisFacialEntity, AnalisisFacialDTO.class);
    }

}