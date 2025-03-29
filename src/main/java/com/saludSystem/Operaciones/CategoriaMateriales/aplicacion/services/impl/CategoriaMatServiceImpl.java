package com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.services.impl;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.ActualizarCategoriaMatDTO;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.CategoriaMatDTO;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.dtos.CrearCategotiaMatDTO;
import com.saludSystem.Operaciones.CategoriaMateriales.aplicacion.services.CategoriaMatService;
import com.saludSystem.Operaciones.CategoriaMateriales.dominio.CategoriaMatModel;
import com.saludSystem.Operaciones.CategoriaMateriales.infraestructura.repository.CategoriaMatRepository;
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
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CategoriaMatModel categoriaMatModel = new CategoriaMatModel();
        categoriaMatModel.setNombre(crearCategotiaMatDTO.getNombre());
        categoriaMatModel.setDescripcion(crearCategotiaMatDTO.getDescripcion());
        categoriaMatModel.setEstado(crearCategotiaMatDTO.getEstado());
        categoriaMatModel.setHospital(hospital);
        categoriaMatModel.setUser(user);
        categoriaMatRepository.save(categoriaMatModel);
        return new ApiResponse(true, "Categoria materiales registrada correctamente");
    }

    @Override
    public List<CategoriaMatDTO> getCategoriaMaterialList() {
        return categoriaMatRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public ListResponse<CategoriaMatDTO> getAllCategoriaMaterial(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CategoriaMatModel> categoriaMatModelPage = categoriaMatRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CategoriaMatDTO> data = categoriaMatModelPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, categoriaMatModelPage.getTotalElements(), categoriaMatModelPage.getTotalPages(), categoriaMatModelPage.getNumber() + 1);
    }

    @Override
    public CategoriaMatDTO getCategoriaMaterialById(UUID categoriaMaterialId) {
        CategoriaMatModel categoriaMatModel = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria materiales no encontrada"));
        return convertToDTO(categoriaMatModel);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCategoriaMaterial(UUID categoriaMaterialId, ActualizarCategoriaMatDTO actualizarCategoriaMatDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CategoriaMatModel categoriaMatModel = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria material no encontrada"));
        Optional.ofNullable(actualizarCategoriaMatDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(categoriaMatModel::setNombre);
        Optional.ofNullable(actualizarCategoriaMatDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(categoriaMatModel::setDescripcion);
        Optional.ofNullable(actualizarCategoriaMatDTO.getEstado()).ifPresent(categoriaMatModel::setEstado);
        categoriaMatRepository.save(categoriaMatModel);
        return new ApiResponse(true, "Categoria nateriales actualizada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCategoriaMaterial(UUID categoriaMaterialId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(user.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        CategoriaMatModel categoriaMatModel = categoriaMatRepository.findById(categoriaMaterialId).
                orElseThrow( () -> new ResourceNotFoundException("Categoria material no encontrada"));
        categoriaMatRepository.deleteById(categoriaMaterialId);
        return new ApiResponse(true, "Categoria materiales eliminada correctamente");
    }

    private CategoriaMatDTO convertToDTO(CategoriaMatModel categoriaMatModel) {
        return modelMapper.map(categoriaMatModel, CategoriaMatDTO.class);
    }

}