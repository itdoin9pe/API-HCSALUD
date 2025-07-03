package com.saludsystem.application.services.paciente.impl;

import com.saludsystem.application.dtos.paciente.get.RecetaDTO;
import com.saludsystem.application.dtos.paciente.post.CrearRecetaDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarRecetaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.RecetaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.configuracion.UserEntity;
import com.saludsystem.domain.model.paciente.MedicamentoRecetadoEntity;
import com.saludsystem.domain.model.paciente.RecetaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.MedicamentoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.RecetaRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RecetaServiceImpl extends GenericServiceImpl<RecetaEntity, RecetaDTO, UUID,
        CrearRecetaDTO, ActualizarRecetaDTO> implements RecetaService {

    private final PacienteRepository pacienteRepository;
    private final DoctorRepository doctorRepository;
    private final MedicamentoRepository medicamentoRepository;

    public RecetaServiceImpl(RecetaRepository recetaRepository, ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository, DoctorRepository doctorRepository, MedicamentoRepository medicamentoRepository) {
        super(recetaRepository, modelMapper, authValidator, RecetaDTO.class,
                recetaEntity -> modelMapper.map(recetaEntity, RecetaDTO.class));
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

    @Override
    protected void updateEntityFromDto(ActualizarRecetaDTO actualizarRecetaDTO, RecetaEntity entity) {
        // Actualizar paciente si se proporciona
        Optional.ofNullable(actualizarRecetaDTO.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        // Actualizar doctor si se proporciona
        Optional.ofNullable(actualizarRecetaDTO.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        // Actualizar otros campos si se proporcionan
        Optional.ofNullable(actualizarRecetaDTO.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(actualizarRecetaDTO.getObservaciones()).ifPresent(entity::setObservaciones);
        Optional.ofNullable(actualizarRecetaDTO.getEstado()).ifPresent(entity::setEstado);
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
    public ApiResponse update(UUID uuid, ActualizarRecetaDTO actualizarRecetaDTO) {
        return super.update(uuid, actualizarRecetaDTO);
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