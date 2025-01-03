package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.PaisDTO;
import com.saludSystem.entities.Pais;
import com.saludSystem.repositories.modules.Generals.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public PaisDTO savePais(PaisDTO paisDTO) {
        Pais pais = new Pais();
        pais.setIso(paisDTO.getIso());
        pais.setNombre(paisDTO.getNombre());
        pais.setGentilicio(paisDTO.getGentilicio());
        pais.setOrden(paisDTO.getOrden());
        Pais savedPais = paisRepository.save(pais);

        paisDTO.setId(savedPais.getId());
        return paisDTO;
    }

    public List<PaisDTO> getAllPais() {
        return paisRepository.findAll().stream().map(pais -> {
            PaisDTO dto = new PaisDTO();
            dto.setId(pais.getId());
            dto.setIso(pais.getIso());
            dto.setNombre(pais.getNombre());
            dto.setGentilicio(pais.getGentilicio());
            dto.setOrden(pais.getOrden());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<String> getPaisList() {
        return paisRepository.findAll().stream()
                .map(Pais::getNombre)
                .collect(Collectors.toList());
    }
}