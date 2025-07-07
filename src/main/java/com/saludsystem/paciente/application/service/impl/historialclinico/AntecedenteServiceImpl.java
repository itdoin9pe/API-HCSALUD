package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.AntecedenteDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.CrearAntecedenteDTO;
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
public class AntecedenteServiceImpl extends GenericServiceImpl<AntecedentesEntity, CrearAntecedenteDTO,
        AntecedenteDTO, UUID> implements AntecedenteService {

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
    protected void updateEntityFromDto(AntecedentesEntity entity, CrearAntecedenteDTO dto) {
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

    @Override
    public ListResponse<AntecedenteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearAntecedenteDTO updateDto) {
        return super.update(uuid, updateDto);
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