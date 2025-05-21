package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.MedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearMedicamentoRecetadoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarMedicamentoRecetadoDTO;
import com.saludSystem.application.services.Paciente.MedicamentoRecetadoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Paciente.MedicamentoRecetadoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedicamentoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.MedicamentoRecetadoRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicamentoRecetadoServiceImpl implements MedicamentoRecetadoService {

    private final MedicamentoRecetadoRepository medicamentoRecetadoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final MedicamentoRepository medicamentoRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public MedicamentoRecetadoServiceImpl(MedicamentoRecetadoRepository medicamentoRecetadoRepository, SysSaludRepository sysSaludRepository, MedicamentoRepository medicamentoRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.medicamentoRecetadoRepository = medicamentoRecetadoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.medicamentoRepository = medicamentoRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveMedicamentoRecetado(CrearMedicamentoRecetadoDTO crearMedicamentoRecetadoDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        MedicamentoRecetadoEntity medicamentoRecetadoEntity = new MedicamentoRecetadoEntity();
        medicamentoRecetadoEntity.setMedicamentoEntity(medicamentoRepository.findById(crearMedicamentoRecetadoDTO.getMedicamentoId())
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento no encontrado") ));
        medicamentoRecetadoEntity.setDosis(crearMedicamentoRecetadoDTO.getDosis());
        medicamentoRecetadoEntity.setFrecuencia(crearMedicamentoRecetadoDTO.getFrecuencia());
        medicamentoRecetadoEntity.setDuracionDias(crearMedicamentoRecetadoDTO.getDuracionDias());
        medicamentoRecetadoEntity.setIndicaciones(crearMedicamentoRecetadoDTO.getIndicaciones());
        medicamentoRecetadoEntity.setHospital(hospital);
        medicamentoRecetadoEntity.setUser(userEntity);
        medicamentoRecetadoRepository.save(medicamentoRecetadoEntity);
        return new ApiResponse(true, "Medicamento recetado agregado");
    }

    @Override
    public ListResponse<MedicamentoRecetadoDTO> getAllMedicamentoRecetado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MedicamentoRecetadoEntity> medicamentoRecetadoEntityPage = medicamentoRecetadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MedicamentoRecetadoDTO> data = medicamentoRecetadoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, medicamentoRecetadoEntityPage.getTotalElements(), medicamentoRecetadoEntityPage.getTotalPages(), medicamentoRecetadoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateMedicamentoRecetado(UUID medicamentoRecetadoId, ActualizarMedicamentoRecetadoDTO actualizarMedicamentoRecetadoDTO) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        MedicamentoRecetadoEntity medicamentoRecetadoEntity = medicamentoRecetadoRepository.findById(medicamentoRecetadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento recetado no encontrado"));
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getMedicamentoId()).flatMap(medicamentoRepository::findById).ifPresent(medicamentoRecetadoEntity::setMedicamentoEntity);
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getDosis()).ifPresent(medicamentoRecetadoEntity::setDosis);
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getFrecuencia()).ifPresent(medicamentoRecetadoEntity::setFrecuencia);
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getDuracionDias()).ifPresent(medicamentoRecetadoEntity::setDuracionDias);
        Optional.ofNullable(actualizarMedicamentoRecetadoDTO.getIndicaciones()).ifPresent(medicamentoRecetadoEntity::setIndicaciones);
        medicamentoRecetadoRepository.save(medicamentoRecetadoEntity);
        return new ApiResponse(true, "Medicamento recetado actualizado");
    }

    @Override
    public MedicamentoRecetadoDTO getMedicamentoRecetadoById(UUID medicamentoRecetadoId) {
        MedicamentoRecetadoEntity medicamentoRecetadoEntity = medicamentoRecetadoRepository.findById(medicamentoRecetadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Medicamento recetado no encontrado"));
        return convertToDTO(medicamentoRecetadoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteMedicamentoRecetado(UUID medicamentoRecetadoId) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        medicamentoRepository.deleteById(medicamentoRecetadoId);
        return new ApiResponse(true, "Medicamento recetado eliminado");
    }

    private MedicamentoRecetadoDTO convertToDTO(MedicamentoRecetadoEntity medicamentoRecetadoEntity) {
        return modelMapper.map(medicamentoRecetadoEntity, MedicamentoRecetadoDTO.class);
    }

}