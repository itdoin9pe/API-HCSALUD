package com.saludSystem.application.services.Paciente.impl;

import com.saludSystem.application.dtos.Paciente.GET.HoraDTO;
import com.saludSystem.application.dtos.Paciente.GET.PConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPConsentimientoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPConsentimiento;
import com.saludSystem.application.services.GenericServiceImpl;
import com.saludSystem.application.services.Paciente.PConsentimientoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Paciente.PConsentimientoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Catalogo.ConsentimientoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PConsentimientoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Paciente.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PConsentimientoServiceImpl extends GenericServiceImpl<PConsentimientoEntity, PConsentimientoDTO,
        UUID, CrearPConsentimientoDTO, ActualizarPConsentimiento> implements PConsentimientoService {

    private final DoctorRepository doctorRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsentimientoRepository consentimientoRepository;

    public PConsentimientoServiceImpl(
            PConsentimientoRepository pConsentimientoRepository, ModelMapper modelMapper, AuthValidator authValidator,
            DoctorRepository doctorRepository, PacienteRepository pacienteRepository, ConsentimientoRepository consentimientoRepository) {
        super(pConsentimientoRepository, modelMapper, authValidator, PConsentimientoDTO.class,
                pConsentimientoEntity -> modelMapper.map(pConsentimientoEntity, PConsentimientoDTO.class));
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
        this.consentimientoRepository = consentimientoRepository;
    }

    @Override
    protected PConsentimientoEntity convertCreateDtoToEntity(CrearPConsentimientoDTO crearPConsentimientoDTO) {
        PConsentimientoEntity entity = new PConsentimientoEntity();
        entity.setDoctorEntity(doctorRepository.findById(crearPConsentimientoDTO.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado")));
        entity.setFecha(crearPConsentimientoDTO.getFecha());
        // Convertir HoraDTO a LocalTime
        HoraDTO horaDTO = crearPConsentimientoDTO.getHora();
        LocalTime hora = LocalTime.of(
                horaDTO.getHours(),
                horaDTO.getMinutes(),
                horaDTO.getSeconds()
        );
        entity.setHora(hora);
        entity.setApoderadoNombre(crearPConsentimientoDTO.getApoderadoNombre());
        entity.setApoderadoDocumento(crearPConsentimientoDTO.getApoderadoDocumento());
        entity.setApoderadoDireccion(crearPConsentimientoDTO.getApoderadoDireccion());
        entity.setConsentimientoEntity(consentimientoRepository.findById(crearPConsentimientoDTO.getConsentimientoId())
                .orElseThrow(() -> new ResourceNotFoundException("Consentimiento no encontrado")));
        entity.setPacienteEntity(pacienteRepository.findById(crearPConsentimientoDTO.getPacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado")));
        entity.setCuerpo(crearPConsentimientoDTO.getCuerpo());
        entity.setFirma(crearPConsentimientoDTO.getFirma());
        entity.setEstado(crearPConsentimientoDTO.getEstado());
        return entity;
    }

    @Override
    protected void updateEntityFromDto(ActualizarPConsentimiento actualizarPConsentimiento, PConsentimientoEntity entity) {
        Optional.ofNullable(actualizarPConsentimiento.getDoctorId())
                .flatMap(doctorRepository::findById)
                .ifPresent(entity::setDoctorEntity);
        Optional.ofNullable(actualizarPConsentimiento.getFecha())
                .ifPresent(entity::setFecha);
        Optional.ofNullable(actualizarPConsentimiento.getHora())
                .ifPresent(horaDTO -> entity.setHora(LocalTime.of(
                        horaDTO.getHours(),
                        horaDTO.getMinutes(),
                        horaDTO.getSeconds()
                )));
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoNombre())
                .ifPresent(entity::setApoderadoNombre);
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoDocumento())
                .ifPresent(entity::setApoderadoDocumento);
        Optional.ofNullable(actualizarPConsentimiento.getApoderadoDireccion())
                .ifPresent(entity::setApoderadoDireccion);
        Optional.ofNullable(actualizarPConsentimiento.getConsentimientoId())
                .flatMap(consentimientoRepository::findById)
                .ifPresent(entity::setConsentimientoEntity);
        Optional.ofNullable(actualizarPConsentimiento.getPacienteId())
                .flatMap(pacienteRepository::findById)
                .ifPresent(entity::setPacienteEntity);
        Optional.ofNullable(actualizarPConsentimiento.getCuerpo())
                .ifPresent(entity::setCuerpo);
        Optional.ofNullable(actualizarPConsentimiento.getFirma())
                .ifPresent(entity::setFirma);
        Optional.ofNullable(actualizarPConsentimiento.getEstado())
                .ifPresent(entity::setEstado);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse save(CrearPConsentimientoDTO crearPConsentimientoDTO) {
        return super.save(crearPConsentimientoDTO);
    }

    @Override
    public ListResponse<PConsentimientoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse update(UUID uuid, ActualizarPConsentimiento actualizarPConsentimiento) {
        return super.update(uuid, actualizarPConsentimiento);
    }

    @Override
    public PConsentimientoDTO getById(UUID uuid) {
        return super.getById(uuid);
    }

    @Override
    public List<PConsentimientoDTO> getList() {
        return super.getList();
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse delete(UUID uuid) {
        return super.delete(uuid);
    }
}