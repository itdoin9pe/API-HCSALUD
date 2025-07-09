package com.saludsystem.paciente.application.service.impl;

import com.saludsystem.paciente.application.dto.get.RecetaDTO;
import com.saludsystem.paciente.application.dto.post.CrearRecetaDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarRecetaDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.RecetaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.paciente.domain.model.MedicamentoRecetadoEntity;
import com.saludsystem.paciente.domain.model.RecetaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.MedicamentoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.RecetaRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecetaServiceImpl extends GenericServiceImpl<RecetaEntity, RecetaDTO, CrearRecetaDTO,
        ActualizarRecetaDTO, UUID> implements RecetaService {

    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final MedicamentoRepository medicamentoRepository;

    public RecetaServiceImpl(RecetaRepository recetaRepository, ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, MedicamentoRepository medicamentoRepository) {
        super(recetaRepository, modelMapper, authValidator, RecetaDTO.class
        );
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    protected RecetaEntity convertCreateDtoToEntity(CrearRecetaDTO crearRecetaDTO) {
        RecetaEntity entity = new RecetaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearRecetaDTO.getPacienteId()).
                orElseThrow( () -> new ResourceNotFoundException("Receta not found")));
        entity.setDoctorEntity(doctorRepository.findById(crearRecetaDTO.getDoctorId()).
                orElseThrow( () -> new ResourceNotFoundException("Doctor not found")));
        entity.setFecha(crearRecetaDTO.getFecha());
        entity.setObservaciones(crearRecetaDTO.getObservaciones());
        entity.setEstado(crearRecetaDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(RecetaEntity entity, ActualizarRecetaDTO dto) {
        // Actualizar paciente si se proporciona
        Optional.ofNullable(dto.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        // Actualizar doctor si se proporciona
        Optional.ofNullable(dto.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        // Actualizar otros campos si se proporcionan
        Optional.ofNullable(dto.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getObservaciones()).ifPresent(entity::setObservaciones);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
    }

    @Override
    protected void beforeSave(RecetaEntity entity, CrearRecetaDTO crearRecetaDTO) {
        // Crear y asociar los medicamentos recetados
        if (crearRecetaDTO.getMedicamentos() != null && !crearRecetaDTO.getMedicamentos().isEmpty()) {
            UserEntity currentUser = authValidator.getCurrentUser();
            List<MedicamentoRecetadoEntity> listaMedicamentos = crearRecetaDTO.getMedicamentos().stream()
                    .map(medDTO -> {
                        MedicamentoRecetadoEntity medEntity = new MedicamentoRecetadoEntity();
                        medEntity.setRecetaEntity(entity);
                        medEntity.setMedicamentoEntity(
                                medicamentoRepository.findById(medDTO.getMedicamentoId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"))
                        );
                        medEntity.setDosis(medDTO.getDosis());
                        medEntity.setFrecuencia(medDTO.getFrecuencia());
                        medEntity.setDuracionDias(medDTO.getDuracionDias());
                        medEntity.setIndicaciones(medDTO.getIndicaciones());
                        medEntity.setHospital(currentUser.getHospital());
                        medEntity.setUser(currentUser);
                        return medEntity;
                    })
                    .toList();
            entity.setMedicamentosRecetados(listaMedicamentos);
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearRecetaDTO crearRecetaDTO) {
        return super.save(crearRecetaDTO);
    }

    @Override
    public ListResponse<RecetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarRecetaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<RecetaDTO> getList() {
        return super.getList();
    }

    @Override
    public RecetaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}