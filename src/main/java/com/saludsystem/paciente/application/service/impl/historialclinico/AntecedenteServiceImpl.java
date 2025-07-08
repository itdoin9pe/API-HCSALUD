package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.AntecedenteResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.AntecedenteRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.AntecedenteService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.HistorialClinico.AntecedentesEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.HistorialClinico.AntecedenteRespository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AntecedenteServiceImpl extends GenericServiceImpl<AntecedentesEntity, AntecedenteRequest,
        AntecedenteResponse, UUID> implements AntecedenteService {

    private final PacienteRepository pacienteRepository;

    public AntecedenteServiceImpl(
            AntecedenteRespository antecedenteRespository,
            ModelMapper modelMapper, AuthValidator authValidator, PacienteRepository pacienteRepository) {
        super(antecedenteRespository, modelMapper, authValidator, AntecedenteResponse.class
        );
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    protected AntecedentesEntity convertCreateDtoToEntity(AntecedenteRequest antecedenteRequest) {
        AntecedentesEntity entity = new AntecedentesEntity();
        entity.setPacienteEntity(pacienteRepository.findById(antecedenteRequest.getPacienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Paciente not found")));
        entity.setMotivo(antecedenteRequest.getMotivo());
        entity.setEnfermedad(antecedenteRequest.getEnfermedad());
        entity.setTiempoEnfermedad(antecedenteRequest.getTiempoEnfermedad());
        entity.setSigno(antecedenteRequest.getSigno());
        entity.setRelato(antecedenteRequest.getRelato());
        entity.setFunciones(antecedenteRequest.getFunciones());
        entity.setAntecedentesPersonales(antecedenteRequest.getAntecedentesPersonales());
        entity.setAntecedentesFamiliares(antecedenteRequest.getAntecedentesFamiliares());
        entity.setMedicamento(antecedenteRequest.getMedicamento());
        entity.setNombreMedicamento(antecedenteRequest.getNombreMedicamento());
        entity.setMotivoMedicamento(antecedenteRequest.getMotivoMedicamento());
        entity.setDosis(antecedenteRequest.getDosis());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(AntecedentesEntity entity, AntecedenteRequest dto) {
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
    public ApiResponse save(AntecedenteRequest antecedenteRequest) {
        return super.save(antecedenteRequest);
    }

    @Override
    public ListResponse<AntecedenteResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, AntecedenteRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<AntecedenteResponse> getList() {
        return super.getList();
    }

    @Override
    public AntecedenteResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}