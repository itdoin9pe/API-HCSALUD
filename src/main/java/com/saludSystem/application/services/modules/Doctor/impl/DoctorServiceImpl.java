package com.saludSystem.application.services.modules.Doctor.impl;

import com.saludSystem.application.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.application.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.application.dtos.Doctor.DoctorDTO;
import com.saludSystem.application.dtos.responses.ListResponse;
import com.saludSystem.domain.entities.Doctor;
import com.saludSystem.domain.entities.configuracion.User;
import com.saludSystem.domain.entities.catalogo.Especialidad;
import com.saludSystem.domain.entities.configuracion.SysSalud;
import com.saludSystem.infrastructure.security.exception.ResourceNotFoundException;
import com.saludSystem.infrastructure.repositories.modules.Configuration.UserRepository;
import com.saludSystem.infrastructure.repositories.modules.Catalogo.EspecialidadRepository;
import com.saludSystem.infrastructure.repositories.modules.Configuration.SysSaludRepository;
import com.saludSystem.infrastructure.repositories.modules.Doctor.DoctorRepository;
import com.saludSystem.application.services.modules.Doctor.DoctorService;
import org.modelmapper.ModelMapper;
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
    public Doctor saveDoctor(CrearDoctorDTO crearDoctorDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSalud hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        Doctor doctor = new Doctor();
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
        Optional<Especialidad> especialidad = especialidadRepository.findById(crearDoctorDTO.getEspecialidadId());
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
        return doctorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DoctorDTO> getDoctorById(UUID doctorId) {
        return Optional.ofNullable(doctorRepository.findById(doctorId).map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con ID" + doctorId)));
    }

    @Override
    public ActualizarDoctorDTO updateDoctor(UUID doctorId, ActualizarDoctorDTO actualizarDoctorDTO) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
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
        List<Doctor> doctors = doctorRepository.findByHospital_HospitalId(hospitalId);
        List<DoctorDTO> data = doctors.stream().map(doctor -> {
            DoctorDTO dto = new DoctorDTO();
            dto.setDoctorId(doctor.getDoctorId());
            dto.setTipoDocumento(doctor.getTipoDocumento());
            dto.setNumeroDocumento(doctor.getNumeroDocumento());
            dto.setApellidos(doctor.getApellidos());
            dto.setNombres(doctor.getNombres());
            dto.setDireccion(doctor.getDireccion());
            dto.setCorreo(doctor.getCorreo());
            dto.setAbreviatura(doctor.getAbreviatura());
            dto.setRne(doctor.getRne());
            dto.setFechaNacimiento(doctor.getFechaNacimiento());
            dto.setCelular(doctor.getCelular());
            dto.setTelefono(doctor.getTelefono());
            dto.setSexo(doctor.getSexo());
            dto.setEspecialidadId(doctor.getEspecialidadId() != null ? doctor.getEspecialidadId().getEspecialidadId() : null);
            dto.setColegiatura(doctor.getColegiatura());
            dto.setColor(doctor.getColor());
            dto.setEstado(doctor.getEstado());
            dto.setFotoDoctor(doctor.getFotoDoctor());
            dto.setFotoFirma(doctor.getFotoFirma());
            return dto;
        }).collect(Collectors.toList());
        return new ListResponse<>(data, data.size());
    }

    @Override
    public void deleteDoctor(UUID doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con ID: " + doctorId));
        doctorRepository.delete(doctor);
    }

    private DoctorDTO convertToDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }

}