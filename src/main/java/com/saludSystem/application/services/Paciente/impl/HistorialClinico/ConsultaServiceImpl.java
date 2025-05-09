package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarConsultaDTO;
import com.saludSystem.application.services.Paciente.HistorialClinico.ConsultaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.HistorialClinico.ConsultaEntity;
import com.saludSystem.domain.model.Paciente.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.ConsultaRepository;
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
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveConsulta(CrearConsultaDTO crearConsultaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ConsultaEntity consultaEntity = new ConsultaEntity();
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(crearConsultaDTO.getPacienteId());
        pacienteEntity.ifPresent(consultaEntity::setPacienteEntity);
        consultaEntity.setMotivoConsulta(crearConsultaDTO.getMotivoConsulta());
        consultaEntity.setDiagnosticoPresuntivo(crearConsultaDTO.getDiagnosticoPresuntivo());
        consultaEntity.setTieneAlergia(crearConsultaDTO.isTieneAlergia());
        consultaEntity.setTieneAlergiaTexto(crearConsultaDTO.getTieneAlergiaTexto());
        consultaEntity.setTieneAlergia(crearConsultaDTO.isTieneAlergia());
        consultaEntity.setTieneAlergiaTexto(crearConsultaDTO.getTieneAlergiaTexto());
        consultaEntity.setTomaMedicamento(crearConsultaDTO.isTomaMedicamento());
        consultaEntity.setTomaMedicamentoTexto(crearConsultaDTO.getTomaMedicamentoTexto());
        consultaEntity.setCirugiasPrevias(crearConsultaDTO.isCirugiasPrevias());
        consultaEntity.setCirugiasPreviasTexto(crearConsultaDTO.getCirugiasPreviasTexto());
        consultaEntity.setEnfermedadesCronicas(crearConsultaDTO.getEnfermedadesCronicas());
        consultaEntity.setTransfusionesSanguineas(crearConsultaDTO.isTransfusionesSanguineas());
        consultaEntity.setHistorialPsiquiatrico(crearConsultaDTO.isHistorialPsiquiatrico());
        consultaEntity.setFuma(crearConsultaDTO.isFuma());
        consultaEntity.setConsumeAlcohol(crearConsultaDTO.isConsumeAlcohol());
        consultaEntity.setActividadFisica(crearConsultaDTO.getActividadFisica());
        consultaEntity.setEmbarazada(crearConsultaDTO.isEmbarazada());
        consultaEntity.setUltimaMenstruacion(crearConsultaDTO.getUltimaMenstruacion());
        consultaEntity.setHospital(hospital);
        consultaEntity.setUser(user);
        consultaRepository.save(consultaEntity);
        return new ApiResponse(true, "Consulta gurdada correctamente");
    }

    @Override
    public ConsultaDTO getConsultaById(UUID pacienteConsultaId) {
        ConsultaEntity consultaEntity = consultaRepository.findById(pacienteConsultaId).orElseThrow(
                () -> new ResourceNotFoundException("Consulta no encontrada"));
        return convertToDTO(consultaEntity);
    }

    @Override
    public ListResponse<ConsultaDTO> getAllConsulta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ConsultaEntity> consultaEntityPage = consultaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ConsultaDTO> data = consultaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, consultaEntityPage.getTotalElements(), consultaEntityPage.getTotalPages(), consultaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateConsulta(UUID pacienteConsultaId, ActualizarConsultaDTO actualizarConsultaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        ConsultaEntity consultaEntity = consultaRepository.findById(pacienteConsultaId).orElseThrow(
                () -> new ResourceNotFoundException("Consulta no encontrada"));
        Optional.ofNullable(actualizarConsultaDTO.getMotivoConsulta()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setMotivoConsulta);
        Optional.ofNullable(actualizarConsultaDTO.getDiagnosticoPresuntivo()).ifPresent(consultaEntity::setDiagnosticoPresuntivo);
        Optional.ofNullable(actualizarConsultaDTO.getTieneAlergiaTexto()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setTieneAlergiaTexto);
        Optional.ofNullable(actualizarConsultaDTO.getTomaMedicamentoTexto()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setTomaMedicamentoTexto);
        Optional.ofNullable(actualizarConsultaDTO.getCirugiasPreviasTexto()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setCirugiasPreviasTexto);
        Optional.ofNullable(actualizarConsultaDTO.getEnfermedadesCronicas()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setEnfermedadesCronicas);
        Optional.ofNullable(actualizarConsultaDTO.getActividadFisica()).filter(desc -> !desc.isBlank()).ifPresent(consultaEntity::setActividadFisica);
        Optional.ofNullable(actualizarConsultaDTO.getUltimaMenstruacion()).ifPresent(consultaEntity::setUltimaMenstruacion);
        consultaRepository.save(consultaEntity);
        return new ApiResponse(true, "Consulta modificada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteConsulta(UUID pacienteConsultaId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            throw new RuntimeException("No tienes permisos para realizar esta acción");
        }
        consultaRepository.deleteById(pacienteConsultaId);
        return new ApiResponse(true, "Consulta eliminada correctamente");
    }

    private ConsultaDTO convertToDTO(ConsultaEntity consultaEntity) {
        return modelMapper.map(consultaEntity, ConsultaDTO.class);
    }

}