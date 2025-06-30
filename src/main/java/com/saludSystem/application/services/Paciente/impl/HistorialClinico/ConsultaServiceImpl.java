package com.saludSystem.application.services.Paciente.impl.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.ConsultaDTO;
import com.saludSystem.application.dtos.Paciente.POST.HistorialClinico.CrearConsultaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.HistorialClinico.ActualizarConsultaDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.HistorialClinico.ConsultaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.HistorialClinico.ConsultaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.HistorialClinico.ConsultaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaServiceImpl extends GenericServiceImpl<ConsultaEntity, ConsultaDTO, UUID,
        CrearConsultaDTO, ActualizarConsultaDTO> implements ConsultaService {

    private final PacienteRepository pacienteRepository;
    private final EspecialidadRepository especialidadRepository;

    public ConsultaServiceImpl(
            ConsultaRepository consultaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            PacienteRepository pacienteRepository, EspecialidadRepository especialidadRepository) {
        super(consultaRepository, modelMapper, authValidator, ConsultaDTO.class,
                consultaEntity -> modelMapper.map(consultaEntity, ConsultaDTO.class));
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
    protected void updateEntityFromDto(ActualizarConsultaDTO actualizarConsultaDTO, ConsultaEntity entity) {
        entity.setPacienteEntity(pacienteRepository.findById(actualizarConsultaDTO.getPacienteId())
                .orElseThrow( () -> new ResourceNotFoundException("Consulta not found")));
        entity.setEspecialidadEntity(especialidadRepository.findById(actualizarConsultaDTO.getEspecialidadId())
                .orElseThrow( () -> new ResourceNotFoundException("Especialidad not found")));
        entity.setMotivoConsulta(actualizarConsultaDTO.getMotivoConsulta());
        entity.setDiagnosticoPresuntivo(actualizarConsultaDTO.getDiagnosticoPresuntivo());
        entity.setTieneAlergia(actualizarConsultaDTO.isTieneAlergia());
        entity.setTieneAlergiaTexto(actualizarConsultaDTO.getTieneAlergiaTexto());
        entity.setTomaMedicamento(actualizarConsultaDTO.isTomaMedicamento());
        entity.setCirugiasPrevias(actualizarConsultaDTO.isCirugiasPrevias());
        entity.setEnfermedadesCronicas(actualizarConsultaDTO.getEnfermedadesCronicas());
        entity.setTransfusionesSanguineas(actualizarConsultaDTO.isTransfusionesSanguineas());
        entity.setHistorialPsiquiatrico(actualizarConsultaDTO.isHistorialPsiquiatrico());
        entity.setFuma(actualizarConsultaDTO.isFuma());
        entity.setConsumeAlcohol(actualizarConsultaDTO.isConsumeAlcohol());
        entity.setActividadFisica(actualizarConsultaDTO.getActividadFisica());
        entity.setEmbarazada(actualizarConsultaDTO.isEmbarazada());
        entity.setUltimaMenstruacion(actualizarConsultaDTO.getUltimaMenstruacion());
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
    public ApiResponse update(UUID uuid, ActualizarConsultaDTO actualizarConsultaDTO) {
        return super.update(uuid, actualizarConsultaDTO);
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