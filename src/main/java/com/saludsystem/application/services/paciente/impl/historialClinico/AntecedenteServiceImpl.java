package com.saludsystem.application.services.paciente.impl.historialClinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.AntecedenteDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.application.dtos.paciente.put.historialclinico.ActualizarAntecedenteDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialClinico.AntecedenteService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.HistorialClinico.AntecedentesEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico.AntecedenteRespository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedenteServiceImpl extends GenericServiceImpl<AntecedentesEntity, AntecedenteDTO, UUID,
        CrearAntecedenteDTO, ActualizarAntecedenteDTO> implements AntecedenteService {

    private final PacienteRepository pacienteRepository;

    public AntecedenteServiceImpl(
            AntecedenteRespository antecedenteRespository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(antecedenteRespository, modelMapper, authValidator, AntecedenteDTO.class,
                antecedentesEntity -> modelMapper.map(antecedentesEntity, AntecedenteDTO.class));
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
    protected void updateEntityFromDto(ActualizarAntecedenteDTO actualizarAntecedenteDTO, AntecedentesEntity entity) {
        entity.setMotivo(actualizarAntecedenteDTO.getMotivo());
        entity.setEnfermedad(actualizarAntecedenteDTO.getEnfermedad());
        entity.setTiempoEnfermedad(actualizarAntecedenteDTO.getTiempoEnfermedad());
        entity.setSigno(actualizarAntecedenteDTO.getSigno());
        entity.setRelato(actualizarAntecedenteDTO.getRelato());
        entity.setFunciones(actualizarAntecedenteDTO.getFunciones());
        entity.setAntecedentesPersonales(actualizarAntecedenteDTO.getAntecedentesPersonales());
        entity.setAntecedentesFamiliares(actualizarAntecedenteDTO.getAntecedentesFamiliares());
        entity.setMedicamento(actualizarAntecedenteDTO.getMedicamento());
        entity.setNombreMedicamento(actualizarAntecedenteDTO.getNombreMedicamento());
        entity.setMotivoMedicamento(actualizarAntecedenteDTO.getMotivoMedicamento());
        entity.setDosis(actualizarAntecedenteDTO.getDosis());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearAntecedenteDTO crearAntecedenteDTO) {
        return super.save(crearAntecedenteDTO);
    }

    @Override
    public ListResponse<AntecedenteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarAntecedenteDTO actualizarAntecedenteDTO) {
        return super.update(uuid, actualizarAntecedenteDTO);
    }

    @Override
    public List<AntecedenteDTO> getList() {
        return super.getList();
    }

    @Override
    public AntecedenteDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}