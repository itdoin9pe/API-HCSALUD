package com.saludSystem.services.modules.Catalogo.Especialidad.impl;

import com.saludSystem.dtos.catalago.Especialidad.ActualizarEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.CrearEspecialidadDTO;
import com.saludSystem.dtos.catalago.Especialidad.EspecialidadDTO;
import com.saludSystem.entities.catalogo.Especialidad;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.EspecialidadRepository;
import com.saludSystem.services.modules.Catalogo.Especialidad.EspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final ModelMapper modelMapper;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, ModelMapper modelMapper) {
        this.especialidadRepository = especialidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearEspecialidadDTO saveEspecialidad(CrearEspecialidadDTO crearEspecialidadDTO) {
        Especialidad especialidad = modelMapper.map(crearEspecialidadDTO, Especialidad.class);
        especialidadRepository.save(especialidad);
        return modelMapper.map(especialidad, CrearEspecialidadDTO.class);
    }

    @Override
    public ActualizarEspecialidadDTO updateEspecialidad(UUID especialidadId, ActualizarEspecialidadDTO actualizarEspecialidadDTO) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId).orElseThrow(
                () -> new ResourceNotFoundException("Especialidad no encontrada con ID" + especialidadId));
        Optional.ofNullable(actualizarEspecialidadDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setNombre);
        Optional.ofNullable(actualizarEspecialidadDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(especialidad::setDescripcion);
        Optional.ofNullable(actualizarEspecialidadDTO.getEstado()).ifPresent(especialidad::setEstado);
        especialidadRepository.save(especialidad);
        return modelMapper.map(especialidad, ActualizarEspecialidadDTO.class);
    }

    @Override
    public Optional<EspecialidadDTO> getEspecialidadById(UUID especialidadId) {
        return Optional.ofNullable(especialidadRepository.findById(especialidadId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada con ID" + especialidadId)));
    }

    @Override
    public List<EspecialidadDTO> getEspecialidadList() {
        return especialidadRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteEspecialidad(UUID especialidadId) {
        Especialidad especialidad = especialidadRepository.findById(especialidadId)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad eliminada correctamebte"));
        especialidadRepository.delete(especialidad);
    }

    @Override
    public long getTotalCount() {
        return especialidadRepository.count();
    }

    /*
    @Override
    public List<EspecialidadDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Especialidad> especialidadPage =  especialidadRepository.findAll(pageable);
        return especialidadPage.getContent().stream()
                .map(especialidad -> modelMapper.map(especialidad, EspecialidadDTO.class))
                .toList();
    }*/

    private EspecialidadDTO convertToDTO(Especialidad especialidad){
        return modelMapper.map(especialidad, EspecialidadDTO.class);
    }

}