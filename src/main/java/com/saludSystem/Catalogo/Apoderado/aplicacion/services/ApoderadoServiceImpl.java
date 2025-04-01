package com.saludSystem.Catalogo.Apoderado.aplicacion.services;

import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ActualizarApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.ApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.aplicacion.dtos.CrearApoderadoDTO;
import com.saludSystem.Catalogo.Apoderado.dominio.ApoderadoModel;
import com.saludSystem.Catalogo.Apoderado.infraestructura.repository.ApoderadoRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
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
public class ApoderadoServiceImpl implements ApoderadoService {

    private final ApoderadoRepository apoderadoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ApoderadoServiceImpl(ApoderadoRepository apoderadoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.apoderadoRepository = apoderadoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveApoderado(CrearApoderadoDTO crearApoderadoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(userModel.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ApoderadoModel apoderadoModel = new ApoderadoModel();
        apoderadoModel.setNombre(crearApoderadoDTO.getNombre());
        apoderadoModel.setDireccion(crearApoderadoDTO.getDireccion());
        apoderadoModel.setNroDocumento(crearApoderadoDTO.getTelefono());
        apoderadoModel.setTelefono(crearApoderadoDTO.getTelefono());
        apoderadoModel.setEstado(crearApoderadoDTO.getEstado());
        apoderadoModel.setUser(userModel);
        apoderadoModel.setHospital(hospital);
        apoderadoRepository.save(apoderadoModel);
        return new ApiResponse(true, "Apoderado registeado correctamente");
    }

    @Override
    public ApiResponse updateApoderado(UUID apoderadoId, ActualizarApoderadoDTO actualizarApoderadoDTO) {
        ApoderadoModel apoderadoModel = apoderadoRepository.findById(apoderadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Apoderado no encontrado"));
        Optional.ofNullable(actualizarApoderadoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoModel::setNombre);
        Optional.ofNullable(actualizarApoderadoDTO.getDireccion()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoModel::setDireccion);
        Optional.ofNullable(actualizarApoderadoDTO.getTelefono()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoModel::setTelefono);
        Optional.ofNullable(actualizarApoderadoDTO.getNroDocumento()).filter(desc -> !desc.isBlank()).ifPresent(apoderadoModel::setNroDocumento);
        Optional.ofNullable(actualizarApoderadoDTO.getEstado()).ifPresent(apoderadoModel::setEstado);
        apoderadoRepository.save(apoderadoModel);
        return new ApiResponse(true, "Apoderado actualizado correctamente");
    }

    @Override
    public ListResponse<ApoderadoDTO> getAllApoderado(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ApoderadoModel> apoderadoModelPage = apoderadoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ApoderadoDTO> data = apoderadoModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, apoderadoModelPage.getTotalElements(), apoderadoModelPage.getTotalPages(), apoderadoModelPage.getNumber() + 1);
    }

    @Override
    public ApoderadoDTO getApoderadoById(UUID apoderadoId) {
        ApoderadoModel apoderadoModel = apoderadoRepository.findById(apoderadoId)
                .orElseThrow( () -> new ResourceNotFoundException("Apoderado no encontrado"));
        return convertToDTO(apoderadoModel);
    }

    @Override
    public ApiResponse deleteApoderado(UUID apoderadoId) {
        apoderadoRepository.deleteById(apoderadoId);
        return new ApiResponse(true,  "Apoderado eliminado correctamente");
    }

    private ApoderadoDTO convertToDTO(ApoderadoModel apoderadoModel) {
        return modelMapper.map(apoderadoModel, ApoderadoDTO.class);
    }
}