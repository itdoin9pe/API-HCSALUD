package com.saludSystem.services.modules.configuration.Sede.impl;

import com.saludSystem.dtos.configuration.Sede.CrearSedeDTO;
import com.saludSystem.dtos.configuration.Sede.SedeDTO;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import com.saludSystem.services.modules.configuration.Sede.SedeService;
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
public class SedeServiceImpl implements SedeService {

    private final SedeRepository sedeRepository;
    private final ModelMapper modelMapper;

    public SedeServiceImpl(SedeRepository sedeRepository, ModelMapper modelMapper)
    {
        this.sedeRepository = sedeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearSedeDTO saveSede(CrearSedeDTO crearSedeDTO) {
        Sede sede = modelMapper.map(crearSedeDTO, Sede.class);
        sedeRepository.save(sede);
        return modelMapper.map(sede, CrearSedeDTO.class);
    }

    @Override
    public SedeDTO updateSede(UUID id, SedeDTO sedeDTO)
    {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Sede no encontrada" + id));
        sede.setCodigo(sedeDTO.getCodigo());
        sede.setNombre(sedeDTO.getNombre());
        sede.setDireccion(sedeDTO.getDireccion());
        sede.setUbigeo(sedeDTO.getUbigeo());
        sede.setEstado(sedeDTO.getEstado());
        Sede updatedSede = sedeRepository.save(sede);
        return convertToDTO(updatedSede);
    }

    @Override
    public void deleteSede(UUID id)
    {
        Sede sede = sedeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sede no encontrada con ID" + id));
        sedeRepository.delete(sede);
    }

    @Override
    public Optional<SedeDTO> getSedeById(UUID id)
    {
        return Optional.ofNullable(sedeRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Sede no encontrada por ID" + id)));
    }

    @Override
    public List<SedeDTO> getSedeList()
    {
        return sedeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long getTotalCount() {
        return sedeRepository.count();
    }

    @Override
    public List<SedeDTO> getPagedResults(UUID hospitalId , int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Sede> sedePage = sedeRepository.findAll(pageable);
        return sedePage.getContent().stream()
                .map(sede -> modelMapper.map(sede, SedeDTO.class))
                .toList();
    }

    private SedeDTO convertToDTO(Sede sede) {
        return modelMapper.map(sede, SedeDTO.class);
    }

}
