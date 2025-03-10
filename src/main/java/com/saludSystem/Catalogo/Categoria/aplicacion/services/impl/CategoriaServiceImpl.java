package com.saludSystem.Catalogo.Categoria.aplicacion.services.impl;

import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.ActualizarCategoriaDTO;
import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CategoriaDTO;
import com.saludSystem.Catalogo.Categoria.aplicacion.dtos.CrearCategoriaDTO;
import com.saludSystem.Catalogo.Categoria.dominio.CategoriaModel;
import com.saludSystem.Catalogo.Categoria.infraestructura.repositories.CategoriaRepository;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.SysSalud.infraestructura.repositories.SysSaludRepository;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Configuracion.Usuario.infraestructura.repositories.UserRepository;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Catalogo.Categoria.aplicacion.services.CategoriaService;
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
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveCategoria(CrearCategoriaDTO crearCategoriaDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserModel user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludModel hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CategoriaModel categoria = new CategoriaModel();
        categoria.setNombre(crearCategoriaDTO.getNombre());
        categoria.setEstado(crearCategoriaDTO.getEstado());
        categoria.setHospital(hospital);
        categoria.setUser(user);
        categoriaRepository.save(categoria);
        return new ApiResponse(true, "Categoria creada correctamente");
    }

    @Override
    public List<CategoriaDTO> getCategoriaList() {
        return categoriaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteCategoria(UUID categoriaId) {
        categoriaRepository.deleteById(categoriaId);
        return new ApiResponse(true, "Categoria eliminada correctamente");
    }

    @Override
    public ApiResponse updateCategoria(UUID categoriaId, ActualizarCategoriaDTO actualizarCategoriaDTO) {
        CategoriaModel categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->  new ResourceNotFoundException("Categoria no encontrada con ID" + categoriaId));
        Optional.ofNullable(actualizarCategoriaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(categoria::setNombre);
        Optional.ofNullable(actualizarCategoriaDTO.getEstado()).ifPresent(categoria::setEstado);
        categoriaRepository.save(categoria);
        return new ApiResponse(true, "Categoria actualizada correctamente");
    }

    @Override
    public CategoriaDTO getCategoriaById(UUID categoriaId) {
        CategoriaModel categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow( () -> new ResourceNotFoundException("Categoria no encontrada"));
        CategoriaDTO dto = new CategoriaDTO();
        dto.setCategoriaId(categoria.getCategoriaId());
        dto.setNombre(categoria.getNombre());
        dto.setEstado(categoria.getEstado());
        return dto;
    }

    @Override
    public ListResponse<CategoriaDTO> getAllCategoria(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CategoriaModel> categoriaPage = categoriaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CategoriaDTO> data = categoriaPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, categoriaPage.getTotalElements(), categoriaPage.getTotalPages(), categoriaPage.getNumber() + 1);
    }

    private CategoriaDTO convertToDTO(CategoriaModel categoria) {
        return modelMapper.map(categoria, CategoriaDTO.class);
    }

}