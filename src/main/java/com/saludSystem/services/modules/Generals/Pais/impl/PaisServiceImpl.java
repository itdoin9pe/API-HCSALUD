package com.saludSystem.services.modules.Generals.Pais.impl;

import com.saludSystem.dtos.Generals.Pais.CrearPaisDTO;
import com.saludSystem.dtos.Generals.Pais.PaisDTO;
import com.saludSystem.entities.Pais;
import com.saludSystem.repositories.modules.Generals.PaisRepository;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PaisServiceImpl(PaisRepository paisRepository, ModelMapper modelMapper)
    {
        this.paisRepository = paisRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearPaisDTO savePais(CrearPaisDTO crearPaisDTO) {
        Pais pais = modelMapper.map(crearPaisDTO, Pais.class);
        return modelMapper.map(pais, CrearPaisDTO.class);
    }

    @Override
    public List<PaisDTO> getAllPais(int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<Pais> paisPage = paisRepository.findAll(pageable);
        return paisPage.getContent().stream()
                .map(pais -> modelMapper.map(pais, PaisDTO.class))
                .toList();
    }

    @Override
    public List<PaisDTO> getPaisList() {
        return paisRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long getTotalCount() {
        return paisRepository.count();
    }

    private PaisDTO convertToDTO(Pais pais) {
        return modelMapper.map(pais, PaisDTO.class);
    }

}
