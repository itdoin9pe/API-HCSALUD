package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.InformacionClinicaDTO;
import com.saludSystem.entities.InformacionClinica;
import com.saludSystem.repositories.modules.Generals.InformacionClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformacionClinicaService {

    @Autowired
    private InformacionClinicaRepository informacionClinicaRepository;

    public InformacionClinicaDTO saveInformacionClinica(InformacionClinicaDTO informacionClinicaDTO){
        InformacionClinica informacionClinica = new InformacionClinica();
        informacionClinica.setNombre(informacionClinicaDTO.getNombre());
        informacionClinica.setEstado(informacionClinicaDTO.isEstado());
        InformacionClinica savedInformacionClinica = informacionClinicaRepository.save(informacionClinica);

        return convertToDTO(savedInformacionClinica);
    }

    public List<InformacionClinicaDTO> getAllInformacionClinica() {
        return informacionClinicaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<InformacionClinicaDTO> getInformacionClinicaById(int id){
        return informacionClinicaRepository.findById(id)
                .map(this::convertToDTO);
    }

    public void deleteInformacionClinica(int id){
        informacionClinicaRepository.deleteById(id);
    }

    public InformacionClinicaDTO updateInformacionClinica(int id, InformacionClinicaDTO informacionClinicaDTO){
        InformacionClinica informacionClinica = informacionClinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Informacion de Clinica no encontrada" + id));
        informacionClinica.setNombre(informacionClinicaDTO.getNombre());
        informacionClinica.setEstado(informacionClinicaDTO.isEstado());

        InformacionClinica updatedInformacionClinica = informacionClinicaRepository.save(informacionClinica);

        return convertToDTO(updatedInformacionClinica);
    }

    private InformacionClinicaDTO convertToDTO(InformacionClinica informacionClinica) {
        InformacionClinicaDTO informacionClinicaDTO = new InformacionClinicaDTO();
        informacionClinicaDTO.setId(informacionClinica.getId());
        informacionClinicaDTO.setNombre(informacionClinica.getNombre());
        informacionClinicaDTO.setEstado(informacionClinica.isEstado());
        return informacionClinicaDTO;
    }

}
