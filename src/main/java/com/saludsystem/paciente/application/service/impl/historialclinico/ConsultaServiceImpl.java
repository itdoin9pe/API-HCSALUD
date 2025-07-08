package com.saludsystem.paciente.application.service.impl.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.ConsultaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.ConsultaRequest;
import com.saludsystem.shared.application.service.GenericServiceImpl;
import com.saludsystem.paciente.application.service.historialclinico.ConsultaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.paciente.domain.model.HistorialClinico.ConsultaEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.HistorialClinico.ConsultaRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl extends GenericServiceImpl<ConsultaEntity, ConsultaRequest, ConsultaResponse, UUID>
        implements ConsultaService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;

    public ConsultaServiceImpl(
            ConsultaRepository consultaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository) {
        super(consultaRepository, modelMapper, authValidator, ConsultaResponse.class);
        this.pacienteRepository = pacienteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    protected ConsultaEntity convertCreateDtoToEntity(ConsultaRequest consultaRequest) {
        ConsultaEntity entity = new ConsultaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(consultaRequest.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Consulta not found")));
        entity.setEspecialidadEntity(especialidadRepository.findById(consultaRequest.getEspecialidadId())
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad not found")));
        entity.setMotivoConsulta(consultaRequest.getMotivoConsulta());
        entity.setDiagnosticoPresuntivo(consultaRequest.getDiagnosticoPresuntivo());
        entity.setTieneAlergia(consultaRequest.isTieneAlergia());
        entity.setTieneAlergiaTexto(consultaRequest.getTieneAlergiaTexto());
        entity.setTomaMedicamento(consultaRequest.isTomaMedicamento());
        entity.setCirugiasPrevias(consultaRequest.isCirugiasPrevias());
        entity.setEnfermedadesCronicas(consultaRequest.getEnfermedadesCronicas());
        entity.setTransfusionesSanguineas(consultaRequest.isTransfusionesSanguineas());
        entity.setHistorialPsiquiatrico(consultaRequest.isHistorialPsiquiatrico());
        entity.setFuma(consultaRequest.isFuma());
        entity.setConsumeAlcohol(consultaRequest.isConsumeAlcohol());
        entity.setActividadFisica(consultaRequest.getActividadFisica());
        entity.setEmbarazada(consultaRequest.isEmbarazada());
        entity.setUltimaMenstruacion(consultaRequest.getUltimaMenstruacion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ConsultaEntity entity, ConsultaRequest dto) {
        entity.setPacienteEntity(pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Consulta not found")));
        entity.setEspecialidadEntity(especialidadRepository.findById(dto.getEspecialidadId())
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad not found")));
        entity.setMotivoConsulta(dto.getMotivoConsulta());
        entity.setDiagnosticoPresuntivo(dto.getDiagnosticoPresuntivo());
        entity.setTieneAlergia(dto.isTieneAlergia());
        entity.setTieneAlergiaTexto(dto.getTieneAlergiaTexto());
        entity.setTomaMedicamento(dto.isTomaMedicamento());
        entity.setCirugiasPrevias(dto.isCirugiasPrevias());
        entity.setEnfermedadesCronicas(dto.getEnfermedadesCronicas());
        entity.setTransfusionesSanguineas(dto.isTransfusionesSanguineas());
        entity.setHistorialPsiquiatrico(dto.isHistorialPsiquiatrico());
        entity.setFuma(dto.isFuma());
        entity.setConsumeAlcohol(dto.isConsumeAlcohol());
        entity.setActividadFisica(dto.getActividadFisica());
        entity.setEmbarazada(dto.isEmbarazada());
        entity.setUltimaMenstruacion(dto.getUltimaMenstruacion());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(ConsultaRequest consultaRequest) {
        return super.save(consultaRequest);
    }

    @Override
    public ListResponse<ConsultaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ConsultaRequest updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<ConsultaResponse> getList() {
        return super.getList();
    }

    @Override
    public ConsultaResponse getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}