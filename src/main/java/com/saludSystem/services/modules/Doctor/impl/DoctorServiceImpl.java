package com.saludSystem.services.modules.Doctor.impl;

import com.saludSystem.dtos.Doctor.ActualizarDoctorDTO;
import com.saludSystem.dtos.Doctor.CrearDoctorDTO;
import com.saludSystem.dtos.Doctor.DoctorDTO;
import com.saludSystem.entities.Doctor;
import com.saludSystem.entities.catalogo.Especialidad;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.EspecialidadRepository;
import com.saludSystem.repositories.modules.Doctor.DoctorRepository;
import com.saludSystem.services.modules.Doctor.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final EspecialidadRepository especialidadRepository;
    private final ModelMapper modelMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, EspecialidadRepository especialidadRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Doctor saveDoctor(CrearDoctorDTO crearDoctorDTO) {
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
        doctor.setFotoDoctor(crearDoctorDTO.getFotoDoctor());
        doctor.setFotoFirma(crearDoctorDTO.getFotoFirma());
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
    public void deleteDoctor(UUID doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado con ID: " + doctorId));
        doctorRepository.delete(doctor);
    }

    @Override
    public long getTotalCount() {
        return doctorRepository.count();
    }

    /*
    @Override
    public List<DoctorDTO> getPagedResults(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page -1, rows);
        Page<Doctor> doctorPage = doctorRepository.findAll(pageable);
        return doctorPage.getContent().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .toList();
    }*/

    private DoctorDTO convertToDTO(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDTO.class);
    }
}
