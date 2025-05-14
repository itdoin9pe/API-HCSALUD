package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.services.Operaciones.CategoriaMatService;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarCategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.GET.CategoriaMatDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearCategotiaMatDTO;
import com.saludSystem.domain.model.Operaciones.CategoriaMatEntity;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.CategoriaMatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoriaMatServiceImpl implements CategoriaMatService {

    private final CategoriaMatRepository categoriaMatRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CategoriaMatServiceImpl(CategoriaMatRepository categoriaMatRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.categoriaMatRepository = categoriaMatRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCategoriaMaterial(CrearCategotiaMatDTO crearCategotiaMatDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CategoriaMatEntity categoriaMatEntity = new CategoriaMatEntity();
        categoriaMatEntity.setNombre(crearCategotiaMatDTO.getNombre());
        categoriaMatEntity.setDescripcion(crearCategotiaMatDTO.getDescripcion());
        categoriaMatEntity.setEstado(crearCategotiaMatDTO.getEstado());
        categoriaMatEntity.setHospital(hospital);
        categoriaMatEntity.setUser(user);
        categoriaMatRepository.save(categoriaMatEntity);
        return new ApiResponse(true, "Categoria materiales registrada correctamente");
    }

    @Override
    public List<CategoriaMatDTO> getCategoriaMaterialList() {
        return categoriaMatRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CategoriaMatDTO> getAllCategoriaMaterial(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CategoriaMatEntity> categoriaMatModelPage = categoriaMatRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CategoriaMatDTO> data = categoriaMatModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, categoriaMatModelPage.getTotalElements(), categoriaMatModelPage.getTotalPages(), categoriaMatModelPage.getNumber() + 1);
    }

    @Override
    public CategoriaMatDTO getCategoriaMaterialById(UUID categoriaMaterialId) {
        CategoriaMatEntity categoriaMatEntity = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria materiales no encontrada"));
        return convertToDTO(categoriaMatEntity);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCategoriaMaterial(UUID categoriaMaterialId, ActualizarCategoriaMatDTO actualizarCategoriaMatDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CategoriaMatEntity categoriaMatEntity = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria material no encontrada"));
        Optional.ofNullable(actualizarCategoriaMatDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(categoriaMatEntity::setNombre);
        Optional.ofNullable(actualizarCategoriaMatDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(categoriaMatEntity::setDescripcion);
        Optional.ofNullable(actualizarCategoriaMatDTO.getEstado()).ifPresent(categoriaMatEntity::setEstado);
        categoriaMatRepository.save(categoriaMatEntity);
        return new ApiResponse(true, "Categoria nateriales actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCategoriaMaterial(UUID categoriaMaterialId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CategoriaMatEntity categoriaMatEntity = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria material no encontrada"));
        categoriaMatRepository.deleteById(categoriaMaterialId);
        return new ApiResponse(true, "Categoria materiales eliminada correctamente");
    }

    private CategoriaMatDTO convertToDTO(CategoriaMatEntity categoriaMatEntity) {
        return modelMapper.map(categoriaMatEntity, CategoriaMatDTO.class);
    }

}