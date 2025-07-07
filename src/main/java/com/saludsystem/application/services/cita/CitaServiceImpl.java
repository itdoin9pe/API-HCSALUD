package com.saludsystem.application.services.cita;

import com.saludsystem.application.dtos.cita.get.CitaDTO;
import com.saludsystem.application.dtos.cita.post.CrearCitaDTO;
import com.saludsystem.application.services.GenericServiceImpl;
import com.saludsystem.domain.model.cita.CitaEntity;
import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.EspecialidadRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.catalogo.TipoCitadoRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.cita.CitaRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.configuracion.SedeRepository;
import com.saludsystem.infrastructure.adapters.out.persistance.repository.paciente.PacienteRepository;
import com.saludsystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, CrearCitaDTO, CitaDTO, UUID> implements CitaService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final PacienteRepository pacienteRepository;
    private final SedeRepository sedeRepository;
    private final TipoCitadoRepository tipoCitadoRepository;

    public CitaServiceImpl(
            CitaRepository citaRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository,
            PacienteRepository pacienteRepository, SedeRepository sedeRepository, TipoCitadoRepository tipoCitadoRepository) {
        super(citaRepository, modelMapper, authValidator, CitaDTO.class);
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
    protected void updateEntityFromDto(CitaEntity entity, CrearCitaDTO dto) {
        Optional.ofNullable(dto.getDoctorEntity()).flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(dto.getEspecialidadEntity()).flatMap(especialidadRepository::findById)
                .ifPresent(entity::setEspecialidadEntity);
        Optional.ofNullable(dto.getPacienteEntity()).flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(dto.getSedeEntity()).flatMap(sedeRepository::findById)
                .ifPresent(entity::setSedeEntity);
        Optional.ofNullable(dto.getTipoCitadoEntity()).flatMap(tipoCitadoRepository::findById)
                .ifPresent(entity::setTipoCitadoEntity);
        Optional.ofNullable(dto.getFecha()).ifPresent(entity::setFecha);
        Optional.ofNullable(dto.getHoraInicio()).ifPresent(entity::setHoraInicio);
        Optional.ofNullable(dto.getHoraFin()).ifPresent(entity::setHoraFin);
        Optional.ofNullable(dto.getEstado()).ifPresent(entity::setEstado);
        Optional.ofNullable(dto.getMotivoConsulta()).ifPresent(entity::setMotivoConsulta);
        Optional.ofNullable(dto.getObservacion()).ifPresent(entity::setObservacion);
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
    public ApiResponse update(UUID uuid, CrearCitaDTO updateDto) {
        return super.update(uuid, updateDto);
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