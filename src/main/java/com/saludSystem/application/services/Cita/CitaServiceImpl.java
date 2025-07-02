package com.saludSystem.application.services.Cita;

import com.saludSystem.application.dtos.Cita.GET.CitaDTO;
import com.saludSystem.application.dtos.Cita.POST.CrearCitaDTO;
import com.saludSystem.application.dtos.Cita.PUT.ActualizarCitaDTO;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.domain.model.CIta.CitaEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.TipoCitadoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Cita.CitaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SedeRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, CitaDTO, UUID,
        CrearCitaDTO, ActualizarCitaDTO> implements CitaService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final PacienteRepository pacienteRepository;
    private final SedeRepository sedeRepository;
    private final TipoCitadoRepository tipoCitadoRepository;

    public CitaServiceImpl(
            CitaRepository citaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository,
            PacienteRepository pacienteRepository, SedeRepository sedeRepository, TipoCitadoRepository tipoCitadoRepository) {
        super(citaRepository, modelMapper, authValidator, CitaDTO.class,
                citaEntity -> modelMapper.map(citaEntity, CitaDTO.class));
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.pacienteRepository = pacienteRepository;
        this.sedeRepository = sedeRepository;
        this.tipoCitadoRepository = tipoCitadoRepository;
    }

    @Override
    protected CitaEntity convertCreateDtoToEntity(CrearCitaDTO crearCitaDTO) {
        CitaEntity entity = new CitaEntity();
        doctorRepository.findById(crearCitaDTO.getDoctorEntity()).ifPresent(entity::setDoctorEntity);
        especialidadRepository.findById(crearCitaDTO.getEspecialidadEntity()).ifPresent(entity::setEspecialidadEntity);
        pacienteRepository.findById(crearCitaDTO.getPacienteEntity()).ifPresent(entity::setPacienteEntity);
        sedeRepository.findById(crearCitaDTO.getSedeEntity()).ifPresent(entity::setSedeEntity);
        tipoCitadoRepository.findById(crearCitaDTO.getTipoCitadoEntity()).ifPresent(entity::setTipoCitadoEntity);
        entity.setFecha(crearCitaDTO.getFecha());
        entity.setHoraInicio(crearCitaDTO.getHoraInicio());
        entity.setHoraFin(crearCitaDTO.getHoraFin());
        entity.setEstado(crearCitaDTO.getEstado());
        entity.setMotivoConsulta(crearCitaDTO.getMotivoConsulta());
        entity.setObservacion(crearCitaDTO.getObservacion());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarCitaDTO actualizarCitaDTO, CitaEntity entity) {
        Optional.ofNullable(actualizarCitaDTO.getDoctorEntity()).flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(actualizarCitaDTO.getEspecialidadEntity()).flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(actualizarCitaDTO.getPacienteEntity()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(actualizarCitaDTO.getSedeEntity()).flatMap(sedeRepository::findById)
                .ifPresent(entity::setSedeEntity);
        Optional.ofNullable(actualizarCitaDTO.getTipoCitadoEntity()).flatMap(tipoCitadoRepository::findById)
                .ifPresent(entity::setTipoCitadoEntity);
        entity.setFecha(actualizarCitaDTO.getFecha());
        entity.setHoraInicio(actualizarCitaDTO.getHoraInicio());
        entity.setHoraFin(actualizarCitaDTO.getHoraFin());
        entity.setEstado(actualizarCitaDTO.getEstado());
        entity.setMotivoConsulta(actualizarCitaDTO.getMotivoConsulta());
        entity.setObservacion(actualizarCitaDTO.getObservacion());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearCitaDTO crearCitaDTO) {
        return super.save(crearCitaDTO);
    }

    @Override
    public ListResponse<CitaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarCitaDTO actualizarCitaDTO) {
        return super.update(uuid, actualizarCitaDTO);
    }

    @Override
    public CitaDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<CitaDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}