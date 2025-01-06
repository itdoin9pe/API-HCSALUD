package com.saludSystem.services.modules.Generals;

import com.saludSystem.dtos.Generals.TipoPacienteDTO;
import com.saludSystem.entities.TipoPaciente;
import com.saludSystem.repositories.modules.Generals.TipoPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoPacienteService {

    @Autowired
    TipoPacienteRepository tipoPacienteRepository;

    public List<TipoPacienteDTO> getAllTipoPaciente(){
        return tipoPacienteRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TipoPacienteDTO> getTipoPacienteById(int tipoPacienteId){
        return tipoPacienteRepository.findById(tipoPacienteId)
                .map(this::convertToDTO);
    }

    public void deleteTipoPaciente(int tipoPacienteId){
        tipoPacienteRepository.deleteById(tipoPacienteId);
    }

    private TipoPacienteDTO updateTipoPaciente(int tipoPacienteId, TipoPacienteDTO tipoPacienteDTO){
        TipoPaciente tipoPaciente = tipoPacienteRepository.findById(tipoPacienteId)
                .orElseThrow(() -> new RuntimeException("Tipo Paciente no encontrado"));

        tipoPaciente.setNombre(tipoPacienteDTO.getNombre());

        TipoPaciente updatedTipoPaciente = tipoPacienteRepository.save(tipoPaciente);

        return convertToDTO(updatedTipoPaciente);
    }

    private TipoPacienteDTO convertToDTO(TipoPaciente tipoPaciente) {
        TipoPacienteDTO tipoPacienteDTO = new TipoPacienteDTO();
        tipoPacienteDTO.setTipoPacienteId(tipoPaciente.getTipoPacienteId());
        tipoPacienteDTO.setNombre(tipoPaciente.getNombre());

        return tipoPacienteDTO;
    }
}
