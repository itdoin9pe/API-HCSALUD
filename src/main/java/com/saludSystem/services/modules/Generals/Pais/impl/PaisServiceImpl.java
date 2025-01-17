package com.saludSystem.services.modules.Generals.Pais.impl;

import com.saludSystem.dtos.Generals.PaisDTO;
import com.saludSystem.entities.Pais;
import com.saludSystem.repositories.modules.Generals.PaisRepository;
import com.saludSystem.services.modules.Generals.Pais.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisServiceImpl implements PaisService {

    private final PaisRepository paisRepository;

    @Autowired
    public PaisServiceImpl(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @Override
    public PaisDTO savePais(PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setIso(paisDTO.getIso());
        pais.setNombre(paisDTO.getNombre());
        pais.setGentilicio(paisDTO.getGentilicio());
        pais.setOrden(paisDTO.getOrden());
        Pais savedPais = paisRepository.save(pais);
        return convertToDTO(savedPais);
    }

    @Override
    public List<PaisDTO> getAllPais() {
        return paisRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getPaisList() {
        return paisRepository.findAll()
                .stream()
                .map(Pais::getNombre)
                .collect(Collectors.toList());
    }

    private PaisDTO convertToDTO(Pais pais) {
        PaisDTO paisDTO = new PaisDTO();
        paisDTO.setId(pais.getId());
        paisDTO.setIso(pais.getIso());
        paisDTO.setNombre(pais.getNombre());
        paisDTO.setGentilicio(pais.getGentilicio());
        paisDTO.setOrden(pais.getOrden());
        return paisDTO;
    }

}
