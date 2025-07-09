package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.AntecedenteDTO;
import com.saludsystem.paciente.application.dto.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.paciente.application.dto.put.historialclinico.ActualizarAntecedenteDTO;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.AntecedenteService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.historialclinico.AntecedentesEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.historialclinico.AntecedenteRespository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AntecedenteServiceImpl extends GenericServiceImpl<AntecedentesEntity, AntecedenteDTO,
        CrearAntecedenteDTO, ActualizarAntecedenteDTO, UUID> implements AntecedenteService {

    private final PacienteRepository pacienteRepository;

    public AntecedenteServiceImpl(
            AntecedenteRespository antecedenteRespository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(antecedenteRespository, modelMapper, authValidator, AntecedenteDTO.class
        );
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected AntecedentesEntity convertCreateDtoToEntity(CrearAntecedenteDTO crearAntecedenteDTO) {
        AntecedentesEntity entity = new AntecedentesEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearAntecedenteDTO.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found")));
        entity.setMotivo(crearAntecedenteDTO.getMotivo());
        entity.setEnfermedad(crearAntecedenteDTO.getEnfermedad());
        entity.setTiempoEnfermedad(crearAntecedenteDTO.getTiempoEnfermedad());
        entity.setSigno(crearAntecedenteDTO.getSigno());
        entity.setRelato(crearAntecedenteDTO.getRelato());
        entity.setFunciones(crearAntecedenteDTO.getFunciones());
        entity.setAntecedentesPersonales(crearAntecedenteDTO.getAntecedentesPersonales());
        entity.setAntecedentesFamiliares(crearAntecedenteDTO.getAntecedentesFamiliares());
        entity.setMedicamento(crearAntecedenteDTO.getMedicamento());
        entity.setNombreMedicamento(crearAntecedenteDTO.getNombreMedicamento());
        entity.setMotivoMedicamento(crearAntecedenteDTO.getMotivoMedicamento());
        entity.setDosis(crearAntecedenteDTO.getDosis());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AntecedentesEntity entity, ActualizarAntecedenteDTO dto) {
        entity.setMotivo(dto.getMotivo());
        entity.setEnfermedad(dto.getEnfermedad());
        entity.setTiempoEnfermedad(dto.getTiempoEnfermedad());
        entity.setSigno(dto.getSigno());
        entity.setRelato(dto.getRelato());
        entity.setFunciones(dto.getFunciones());
        entity.setAntecedentesPersonales(dto.getAntecedentesPersonales());
        entity.setAntecedentesFamiliares(dto.getAntecedentesFamiliares());
        entity.setMedicamento(dto.getMedicamento());
        entity.setNombreMedicamento(dto.getNombreMedicamento());
        entity.setMotivoMedicamento(dto.getMotivoMedicamento());
        entity.setDosis(dto.getDosis());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearAntecedenteDTO crearAntecedenteDTO) {
        return super.save(crearAntecedenteDTO);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarAntecedenteDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}