package com.saludSystem.Operaciones.Presentacion.aplicacion.services;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.ActualizarPresentacionDTO;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.CrearPresentacionDTO;
import com.saludSystem.Operaciones.Presentacion.aplicacion.dtos.PresentacionDTO;
import com.saludSystem.Operaciones.Presentacion.dominio.PresentacionModel;
import com.saludSystem.Operaciones.Presentacion.infraestructura.repository.PresentacionReposirory;
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
public class PresentacionServiceImpl implements PresentacionService{

    private final PresentacionReposirory presentacionReposirory;
    private final UserRepository userRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ModelMapper modelMapper;

    public PresentacionServiceImpl(PresentacionReposirory presentacionReposirory, UserRepository userRepository, SysSaludRepository sysSaludRepository, ModelMapper modelMapper) {
        this.presentacionReposirory = presentacionReposirory;
        this.userRepository = userRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse savePresentacion(CrearPresentacionDTO crearPresentacionDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        PresentacionModel presentacionModel = new PresentacionModel();
        presentacionModel.setNombre(crearPresentacionDTO.getNombre());
        presentacionModel.setEstado(crearPresentacionDTO.getEstado());
        presentacionModel.setHospital(hospital);
        presentacionModel.setUser(userModel);
        presentacionReposirory.save(presentacionModel);
        return new ApiResponse(true, "Presentacion registrada correctamente");
    }

    @Override
    public PresentacionDTO getPresentacionById(UUID presentacionId) {
        PresentacionModel presentacionModel = presentacionReposirory.findById(presentacionId)
                .orElseThrow( () -> new ResourceNotFoundException("Presentacion not found"));
        return convertToDTO(presentacionModel);
    }

    @Override
    public ListResponse<PresentacionDTO> getAllPresentacion(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<PresentacionModel> presentacionModelPage = presentacionReposirory.findByHospital_HospitalId(hospitalId, pageable);
        List<PresentacionDTO> data = presentacionModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, presentacionModelPage.getTotalElements(), presentacionModelPage.getTotalPages(), presentacionModelPage.getNumber() +1 );
    }

    @Override
    public List<PresentacionDTO> getPresentacionList() {
        return presentacionReposirory.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ApiResponse updatePresentacion(UUID presentacionId, ActualizarPresentacionDTO actualizarPresentacionDTO) {
        PresentacionModel presentacionModel = presentacionReposirory.findById(presentacionId)
                .orElseThrow( () -> new ResourceNotFoundException("Presentacion not found"));
        Optional.ofNullable(actualizarPresentacionDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(presentacionModel::setNombre);
        Optional.ofNullable(actualizarPresentacionDTO.getEstado()).ifPresent(presentacionModel::setEstado);
        presentacionReposirory.save(presentacionModel);
        return new ApiResponse(true, "Presentacion updated successfully");
    }

    @Override
    public ApiResponse deletePresentacion(UUID presentacionId) {
        presentacionReposirory.deleteById(presentacionId);
        return new ApiResponse(true, "Presentacion eliminada correctamente");
    }

    private PresentacionDTO convertToDTO(PresentacionModel presentacionModel) {
        return modelMapper.map(presentacionModel, PresentacionDTO.class);
    }

}
