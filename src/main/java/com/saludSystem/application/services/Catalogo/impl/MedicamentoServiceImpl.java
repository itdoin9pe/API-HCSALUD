package com.saludSystem.application.services.Catalogo.impl;

import com.saludSystem.application.dtos.Catalogo.GET.MedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.POST.CrearMedicamentoDTO;
import com.saludSystem.application.dtos.Catalogo.PUT.ActualizarMedicamentoDTO;
import com.saludSystem.application.services.Catalogo.MedicamentoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Catalogo.MedicamentoEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.MedicamentoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final AuthValidator authValidator;
    private final ModelMapper modelMapper;

    public MedicamentoServiceImpl(MedicamentoRepository medicamentoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, AuthValidator authValidator, ModelMapper modelMapper) {
        this.medicamentoRepository = medicamentoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.authValidator = authValidator;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveMedicamento(CrearMedicamentoDTO crearMedicamentoDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();  // Lanza excepción si no es admin
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(
                () -> new RuntimeException("Hospital no encontrado"));
        MedicamentoEntity medicamentoEntity = new MedicamentoEntity();
        medicamentoEntity.setNombre(crearMedicamentoDTO.getNombre());
        medicamentoEntity.setFormaFarmaceutica(crearMedicamentoDTO.getFormaFarmaceutica());
        medicamentoEntity.setConcentracion(crearMedicamentoDTO.getConcentracion());
        medicamentoEntity.setContenido(crearMedicamentoDTO.getContenido());
        medicamentoEntity.setEstado(crearMedicamentoDTO.getEstado());
        medicamentoEntity.setHospital(hospital);
        medicamentoEntity.setUser(userEntity);
        medicamentoRepository.save(medicamentoEntity);
        return new ApiResponse(true, "Medicamento agregado correctamente");
    }

    @Override
    public List<MedicamentoDTO> getMedicamentoList() {
        return medicamentoRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public MedicamentoDTO getMedicamentoById(UUID medicamentoId) {
        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(medicamentoId).orElseThrow(
                () -> new ResourceNotFoundException("Medicamento no encontrado"));
        return convertToDTO(medicamentoEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateMedicamento(UUID medicamentoId, ActualizarMedicamentoDTO actualizarMedicamentoDTO) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        MedicamentoEntity medicamentoEntity = medicamentoRepository.findById(medicamentoId).orElseThrow(
                () -> new ResourceNotFoundException("Medicamento no encontrado"));
        medicamentoRepository.save(medicamentoEntity);
        return new ApiResponse(true, "Medicamento actualizado correctamente");
    }

    @Override
    public ListResponse<MedicamentoDTO> getAllMedicamento(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<MedicamentoEntity> medicamentoEntityPage = medicamentoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<MedicamentoDTO> data = medicamentoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, medicamentoEntityPage.getTotalElements(), medicamentoEntityPage.getTotalPages(), medicamentoEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteMedicamento(UUID medicamentoId) {
        UserEntity userEntity = authValidator.getCurrentUser();
        authValidator.validateAdminAccess();
        medicamentoRepository.deleteById(medicamentoId);
        return new ApiResponse(true, "Medicamento eliminado correctamente");
    }

    private MedicamentoDTO convertToDTO(MedicamentoEntity medicamentoEntity) {
        return modelMapper.map(medicamentoEntity, MedicamentoDTO.class);
    }

}