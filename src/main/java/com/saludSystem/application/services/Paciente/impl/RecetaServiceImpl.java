package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.RecetaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearRecetaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarRecetaDTO;
import com.saludSystem.application.services.Paciente.RecetaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.MedicamentoRecetadoEntity;
import com.saludSystem.domain.model.Paciente.RecetaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedicamentoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.RecetaRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecetaServiceImpl implements RecetaService {

    private final RecetaRepository recetaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public RecetaServiceImpl(RecetaRepository recetaRepository, SysSaludRepository sysSaludRepository, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, MedicamentoRepository medicamentoRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.recetaRepository = recetaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.medicamentoRepository = medicamentoRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveReceta(CrearRecetaDTO crearRecetaDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();  // Lanza excepción si no es admin
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        var paciente = pacienteRepository.findById(crearRecetaDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));
        var doctor = doctorRepository.findById(crearRecetaDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));
        RecetaEntity receta = new RecetaEntity();
        receta.setPacienteEntity(paciente);
        receta.setDoctorEntity(doctor);
        receta.setFecha(crearRecetaDTO.getFecha() != null ? crearRecetaDTO.getFecha() : LocalDate.now());
        receta.setObservaciones(crearRecetaDTO.getObservaciones());
        receta.setEstado(crearRecetaDTO.getEstado()); // o parsear dto.getEstado() si esperas algo como "ACTIVO"
        receta.setHospital(hospital);
        receta.setUser(userEntity);
        List<MedicamentoRecetadoEntity> listaMedicamentos = crearRecetaDTO.getMedicamentos().stream().map(medDTO -> {
            MedicamentoRecetadoEntity medEntity = new MedicamentoRecetadoEntity();
            medEntity.setRecetaEntity(receta);
            medEntity.setMedicamentoEntity(medicamentoRepository.findById(medDTO.getMedicamentoId()).orElseThrow(
                    () -> new ResourceNotFoundException("Medicamento no enconrado")));
            medEntity.setDosis(medDTO.getDosis());
            medEntity.setFrecuencia(medDTO.getFrecuencia());
            medEntity.setDuracionDias(medDTO.getDuracionDias());
            medEntity.setIndicaciones(medDTO.getIndicaciones());
            medEntity.setHospital(hospital);
            medEntity.setUser(userEntity);
            return medEntity;
        }).toList();
        receta.setMedicamentosRecetados(listaMedicamentos);
        recetaRepository.save(receta);
        return new ApiResponse(true, "Receta agregada");
    }

    @Override
    public ListResponse<RecetaDTO> getAllReceta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<RecetaEntity> recetaEntityPage = recetaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<RecetaDTO> data = recetaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, recetaEntityPage.getTotalPages(), recetaEntityPage.getTotalPages(), recetaEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateReceta(UUID pacienteRecetaId, ActualizarRecetaDTO actualizarRecetaDTO) {
        authValidator.validateAdminAccess();  // Lanza excepción si no es admin
        RecetaEntity recetaEntity = recetaRepository.findById(pacienteRecetaId).orElseThrow(
                () -> new ResourceNotFoundException("Receta no encontrada"));
        Optional.ofNullable(actualizarRecetaDTO.getPacienteId()).flatMap(pacienteRepository::findById).ifPresent(recetaEntity::setPacienteEntity);
        Optional.ofNullable(actualizarRecetaDTO.getDoctorId()).flatMap(doctorRepository::findById).ifPresent(recetaEntity::setDoctorEntity);
        Optional.ofNullable(actualizarRecetaDTO.getFecha()).ifPresent(recetaEntity::setFecha);
        Optional.ofNullable(actualizarRecetaDTO.getObservaciones()).ifPresent(recetaEntity::setObservaciones);
        Optional.ofNullable(actualizarRecetaDTO.getEstado()).ifPresent(recetaEntity::setEstado);
        recetaRepository.save(recetaEntity);
        return new ApiResponse(true, "Receta modificada");
    }

    @Override
    public RecetaDTO getRecetaById(UUID pacienteRecetaId) {
        RecetaEntity recetaEntity = recetaRepository.findById(pacienteRecetaId).orElseThrow(
                () -> new ResourceNotFoundException("Receta no encontrada"));
        return convertToDTO(recetaEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteReceta(UUID pacienteRecetaId) {
        authValidator.validateAdminAccess();  // Lanza excepción si no es admin
        recetaRepository.deleteById(pacienteRecetaId);
        return new ApiResponse(true, "Receta eliminada");
    }

    private RecetaDTO convertToDTO(RecetaEntity recetaEntity) {
        return modelMapper.map(recetaEntity, RecetaDTO.class);
    }

}