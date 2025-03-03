package com.saludSystem.aplicacion.services.modules.Catalogo.Categoria.impl;
/*
import com.saludSystem.dtos.catalago.Categoria.ActualizarCategoriaDTO;
import com.saludSystem.dtos.catalago.Categoria.CategoriaDTO;
import com.saludSystem.dtos.catalago.Categoria.CrearCategoriaDTO;
import com.saludSystem.entities.catalogo.Categoria;
import com.saludSystem.exception.ResourceNotFoundException;
import com.saludSystem.repositories.modules.Catalogo.CategoriaRepository;
import com.saludSystem.services.modules.Catalogo.Categoria.CategoriaService;
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
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ModelMapper modelMapper;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ModelMapper modelMapper) {
        this.categoriaRepository = categoriaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CrearCategoriaDTO saveCategoria(CrearCategoriaDTO crearCategoriaDTO) {
        Categoria categoria = modelMapper.map(crearCategoriaDTO, Categoria.class);
        categoriaRepository.save(categoria);
        return modelMapper.map(categoria, CrearCategoriaDTO.class);
    }

    @Override
    public List<CategoriaDTO> getCategoriaList() {
        return categoriaRepository.findAll().stream()
                .map(this::converToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCategoria(UUID categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow( () -> new ResourceNotFoundException("Categoria no encontrado con ID" + categoriaId));
        categoriaRepository.delete(categoria);
    }

    @Override
    public ActualizarCategoriaDTO updateCategoria(UUID categoriaId, ActualizarCategoriaDTO actualizarCategoriaDTO) {
        Categoria categoria = categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->  new ResourceNotFoundException("Categoria no encontrada con ID" + categoriaId));
        Optional.ofNullable(actualizarCategoriaDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(categoria::setNombre);
        Optional.ofNullable(actualizarCategoriaDTO.getEstado()).ifPresent(categoria::setEstado);
        categoriaRepository.save(categoria);
        return modelMapper.map(categoria, ActualizarCategoriaDTO.class);
    }

    @Override
    public Optional<CategoriaDTO> getCategoriaById(UUID categoriaId) {
        return Optional.ofNullable(categoriaRepository.findById(categoriaId)
                .map(this::converToDTO)
                .orElseThrow( () -> new ResourceNotFoundException("Categoria no encontrado con Id" + categoriaId)));
    }

    @Override
    public long getTotalCount() {
        return categoriaRepository.count();
    }


    private CategoriaDTO converToDTO(Categoria categoria) {
        return modelMapper.map(categoria, CategoriaDTO.class);
    }
}


 */