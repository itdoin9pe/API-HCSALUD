package com.saludSystem.Catalogo.Alergia.aplicacion.services.impl;

import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.ActualizarAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.AlergiaDTO;
import com.saludSystem.Catalogo.Alergia.aplicacion.dtos.CrearAlergiaDTO;
import com.saludSystem.Catalogo.Alergia.dominio.AlergiaModel;
import com.saludSystem.Catalogo.Alergia.infraestructura.repositories.AlergiaRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Alergia.aplicacion.services.AlergiaService;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
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
public class AlergiaServiceImpl implements AlergiaService {

    private final AlergiaRepository alergiaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AlergiaServiceImpl(AlergiaRepository alergiaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.alergiaRepository = alergiaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ApiResponse saveAlergia(CrearAlergiaDTO crearAlergiaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        AlergiaModel alergia = new AlergiaModel();
        alergia.setNombre(crearAlergiaDTO.getNombre());
        alergia.setEstado(crearAlergiaDTO.getEstado());
        alergia.setUser(userModel);
        alergia.setHospital(hospital);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia registrada correctamente");
    }

    @Override
    public List<AlergiaDTO> getAlergiaList() {
        return alergiaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteAlergia(UUID alergiaId) {
        alergiaRepository.deleteById(alergiaId);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public ApiResponse updateAlergia(UUID alergiaId, ActualizarAlergiaDTO actualizarAlergiaDTO) {
        AlergiaModel alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));
        Optional.ofNullable(actualizarAlergiaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(alergia::setNombre);
        Optional.ofNullable(actualizarAlergiaDTO.getEstado()).ifPresent(alergia::setEstado);
        alergiaRepository.save(alergia);
        return new ApiResponse(true, "Alergia eliminada correctamente");
    }

    @Override
    public AlergiaDTO getAlergiaById(UUID alergiaId) {
        AlergiaModel alergia = alergiaRepository.findById(alergiaId)
                .orElseThrow( () -> new ResourceNotFoundException("Alergia no encontrada"));;
        return convertToDTO(alergia);
    }

    @Override
    public ListResponse<AlergiaDTO> getAllAlergia(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<AlergiaModel> alergiaPage = alergiaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<AlergiaDTO> data = alergiaPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, alergiaPage.getTotalElements(), alergiaPage.getTotalPages(), alergiaPage.getNumber() +1 );
    }

    private AlergiaDTO convertToDTO(AlergiaModel alergia) {
        return modelMapper.map(alergia, AlergiaDTO.class);
    }

}