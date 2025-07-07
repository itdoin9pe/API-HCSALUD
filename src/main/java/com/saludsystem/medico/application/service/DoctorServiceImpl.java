package com.saludsystem.medico.application.service;

import com.saludsystem.medico.application.dto.ActualizarDoctorDTO;
import com.saludsystem.medico.application.dto.CrearDoctorDTO;
import com.saludsystem.medico.application.dto.DoctorDTO;
import com.saludsystem.catalogo.domain.model.EspecialidadEntity;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.medico.domain.model.DoctorEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.medico.infrastructure.adapters.out.persistance.DoctorRepository;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.catalogo.infrastructure.adapters.out.persistance.EspecialidadRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorEntity saveDoctor(CrearDoctorDTO crearDoctorDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        DoctorEntity doctor = new DoctorEntity();
        doctor.setTipoDocumento(crearDoctorDTO.getTipoDocumento());
        doctor.setNumeroDocumento(crearDoctorDTO.getNumeroDocumento());
        doctor.setApellidos(crearDoctorDTO.getApellidos());
        doctor.setNombres(crearDoctorDTO.getNombres());
        doctor.setDireccion(crearDoctorDTO.getDireccion());
        doctor.setCorreo(crearDoctorDTO.getCorreo());
        doctor.setAbreviatura(crearDoctorDTO.getAbreviatura());
        doctor.setRne(crearDoctorDTO.getRne());
        doctor.setFechaNacimiento(crearDoctorDTO.getFechaNacimiento());
        doctor.setCelular(crearDoctorDTO.getCelular());
        doctor.setTelefono(crearDoctorDTO.getTelefono());
        doctor.setSexo(crearDoctorDTO.getSexo());
        Optional<EspecialidadEntity> especialidad = especialidadRepository.findById(crearDoctorDTO.getEspecialidadId());
        especialidad.ifPresent(doctor::setEspecialidadId);
        doctor.setColegiatura(crearDoctorDTO.getColegiatura());
        doctor.setColor(crearDoctorDTO.getColor());
        doctor.setEstado(crearDoctorDTO.getEstado());
        doctor.setFotoDoctor(String.valueOf(crearDoctorDTO.getFotoDoctor()));
        doctor.setFotoFirma(String.valueOf(crearDoctorDTO.getFotoFirma()));
        doctor.setHospital(hospital);
        doctor.setUser(user);
        return doctorRepository.save(doctor);
    }

    @Override
    public List<DoctorDTO> getDoctorList() {
        return doctorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DoctorDTO> getDoctorById(UUID doctorId) {
        return Optional.ofNullable(doctorRepository.findById(doctorId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con ID" + doctorId)));
    }

    @Override
    public ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new ResourceNotFoundException("Doctor no encontrado con ID: " + doctorId));
        Optional.ofNullable(actualizarDoctorDTO.getTipoDocumento()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setTipoDocumento);
        Optional.ofNullable(actualizarDoctorDTO.getNumeroDocumento()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setNumeroDocumento);
        Optional.ofNullable(actualizarDoctorDTO.getApellidos()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setApellidos);
        Optional.ofNullable(actualizarDoctorDTO.getNombres()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setNombres);
        Optional.ofNullable(actualizarDoctorDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setDireccion);
        Optional.ofNullable(actualizarDoctorDTO.getCorreo()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setCorreo);
        Optional.ofNullable(actualizarDoctorDTO.getAbreviatura()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setAbreviatura);
        Optional.ofNullable(actualizarDoctorDTO.getRne()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setRne);
        Optional.ofNullable(actualizarDoctorDTO.getFechaNacimiento()).ifPresent(doctor::setFechaNacimiento);
        Optional.ofNullable(actualizarDoctorDTO.getCelular()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setCelular);
        Optional.ofNullable(actualizarDoctorDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setTelefono);
        Optional.ofNullable(actualizarDoctorDTO.getSexo()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setSexo);
        Optional.ofNullable(actualizarDoctorDTO.getEspecialidadId())
                .flatMap(especialidadRepository::findById)
                .ifPresent(doctor::setEspecialidadId);
        Optional.ofNullable(actualizarDoctorDTO.getColegiatura()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setColegiatura);
        Optional.ofNullable(actualizarDoctorDTO.getColor()).filter(desc -> !desc.isBlank()).ifPresent(doctor::setColor);
        Optional.ofNullable(actualizarDoctorDTO.getEstado()).ifPresent(doctor::setEstado);
        Optional.ofNullable(actualizarDoctorDTO.getFotoDoctor()).ifPresent(doctor::setFotoDoctor);
        Optional.ofNullable(actualizarDoctorDTO.getFotoFirma()).ifPresent(doctor::setFotoFirma);
        doctorRepository.save(doctor);
        return modelMapper.map(doctor, ActualizarDoctorDTO.class);
    }

    @Override
    public ListResponse<DoctorDTO> getAllDoctor(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<DoctorEntity> doctorPage = doctorRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<DoctorDTO> data = doctorPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, doctorPage.getTotalElements(), doctorPage.getTotalPages(), doctorPage.getNumber() + 1);
    }

    @Override
    public void deleteDoctor(UUID doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con ID: " + doctorId));
        doctorRepository.delete(doctor);
    }

    private DoctorDTO convertToDTO(DoctorEntity doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

}