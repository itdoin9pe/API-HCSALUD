package com.saludSystem.services.modules.configuration;

import com.saludSystem.dtos.configuration.SedeDTO;
import com.saludSystem.entities.configuracion.Sede;
import com.saludSystem.repositories.modules.Configuration.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SedeService {

    @Autowired
    SedeRepository sedeRepository;

    public SedeDTO saveSede(SedeDTO sedeDTO){
        Sede sede = new Sede();
        sede.setCodigo(sedeDTO.getCodigo());
        sede.setNombre(sedeDTO.getNombre());
        sede.setDireccion(sedeDTO.getDireccion());
        sede.setUbigeo(sedeDTO.getUbigeo());
        sede.setEstado(sedeDTO.getEstado());

        Sede savedSede = sedeRepository.save(sede);

        return  convertToDTO(savedSede);
    }

    public List<SedeDTO> getAllSedes(){
        return sedeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<SedeDTO> getSedeById(Integer id){
        return sedeRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteSede(Integer id){
        sedeRepository.deleteById(id);
    }

    public SedeDTO updateSede(Integer id, SedeDTO sedeDTO){
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

    // Conversión de entidad a DTO
    private SedeDTO convertToDTO(Sede sede) {
        SedeDTO sedeDTO = new SedeDTO();
        sedeDTO.setId(sede.getId());
        sedeDTO.setCodigo(sede.getCodigo());
        sedeDTO.setNombre(sede.getNombre());
        sedeDTO.setDireccion(sede.getDireccion());
        sedeDTO.setUbigeo(sede.getUbigeo());
        sedeDTO.setEstado(sede.getEstado());

        return sedeDTO;
    }

}
