package com.saludsystem.application.services.paciente.impl.historialclinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ConsultaDTO;
import com.saludsystem.application.dtos.paciente.post.historialclinico.CrearConsultaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.application.services.paciente.historialclinico.ConsultaService;
import com.saludsystem.domain.exception.ResourceNotFoundException;
import com.saludsystem.domain.model.paciente.HistorialClinico.ConsultaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.EspecialidadRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.HistorialClinico.ConsultaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl extends GenericServiceImpl<ConsultaEntity, CrearConsultaDTO, ConsultaDTO, UUID>
        implements ConsultaService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;

    public ConsultaServiceImpl(
            ConsultaRepository consultaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository) {
        super(consultaRepository, modelMapper, authValidator, ConsultaDTO.class);
        this.pacienteRepository = pacienteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    protected ConsultaEntity convertCreateDtoToEntity(CrearConsultaDTO crearConsultaDTO) {
        ConsultaEntity entity = new ConsultaEntity();
        entity.setPacienteEntity(pacienteRepository.findById(crearConsultaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Consulta not found")));
        entity.setEspecialidadEntity(especialidadRepository.findById(crearConsultaDTO.getEspecialidadId())
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad not found")));
        entity.setMotivoConsulta(crearConsultaDTO.getMotivoConsulta());
        entity.setDiagnosticoPresuntivo(crearConsultaDTO.getDiagnosticoPresuntivo());
        entity.setTieneAlergia(crearConsultaDTO.isTieneAlergia());
        entity.setTieneAlergiaTexto(crearConsultaDTO.getTieneAlergiaTexto());
        entity.setTomaMedicamento(crearConsultaDTO.isTomaMedicamento());
        entity.setCirugiasPrevias(crearConsultaDTO.isCirugiasPrevias());
        entity.setEnfermedadesCronicas(crearConsultaDTO.getEnfermedadesCronicas());
        entity.setTransfusionesSanguineas(crearConsultaDTO.isTransfusionesSanguineas());
        entity.setHistorialPsiquiatrico(crearConsultaDTO.isHistorialPsiquiatrico());
        entity.setFuma(crearConsultaDTO.isFuma());
        entity.setConsumeAlcohol(crearConsultaDTO.isConsumeAlcohol());
        entity.setActividadFisica(crearConsultaDTO.getActividadFisica());
        entity.setEmbarazada(crearConsultaDTO.isEmbarazada());
        entity.setUltimaMenstruacion(crearConsultaDTO.getUltimaMenstruacion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ConsultaEntity entity, CrearConsultaDTO dto) {
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
    public ApiResponse save(CrearConsultaDTO crearConsultaDTO) {
        return super.save(crearConsultaDTO);
    }

    @Override
    public ListResponse<ConsultaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, CrearConsultaDTO updateDto) {
        return super.update(uuid, updateDto);
    }

    @Override
    public List<ConsultaDTO> getList() {
        return super.getList();
    }

    @Override
    public ConsultaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}