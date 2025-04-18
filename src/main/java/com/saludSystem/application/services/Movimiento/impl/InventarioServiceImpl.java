package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.AlmacenDTO;
import com.saludSystem.application.dtos.Movimientos.GET.InventarioDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearInventarioDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarInventarioDTO;
import com.saludSystem.application.services.Movimiento.InventarioProjection;
import com.saludSystem.application.services.Movimiento.InventarioService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Movimientos.InventarioEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.InventarioRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.CategoriaMatRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.MarcaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.UnidadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ProductoRepository productoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaMatRepository categoriaMatRepository;
    private final UnidadRepository unidadRepository;
    private final ModelMapper modelMapper;

    public InventarioServiceImpl(InventarioRepository inventarioRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ProductoRepository productoRepository, MarcaRepository marcaRepository, CategoriaMatRepository categoriaMatRepository, UnidadRepository unidadRepository, ModelMapper modelMapper) {
        this.inventarioRepository = inventarioRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaMatRepository = categoriaMatRepository;
        this.unidadRepository = unidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveInventario(CrearInventarioDTO crearInventarioDTO) {
        return new ApiResponse(true, "Registro creado correctamente");
    }

    @Override
    public ApiResponse updateInventario(UUID inventarioId, ActualizarInventarioDTO actualizarInventarioDTO) {
        return new ApiResponse(true, "Registro actualizado correctamente");
    }

    @Override
    public ApiResponse deleteInventario(UUID inventarioId) {
        inventarioRepository.deleteById(inventarioId);
        return new ApiResponse(true, "Registro eliminado correctamente");
    }

    @Override
    public InventarioDTO getInventarioById(UUID inventarioId) {
        InventarioEntity inventarioEntity = inventarioRepository.findById(inventarioId).orElseThrow(
                () -> new ResourceNotFoundException("Inventario no encontrado"));
        return convertToDTO(inventarioEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<InventarioDTO> getAllInventario(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<InventarioProjection> projections = productoRepository.findInventarioDataByHospitalId(hospitalId, pageable);
        List<InventarioDTO> data = projections.getContent().stream()
                .map(p -> new InventarioDTO(
                        p.getNombreAlmacen(),
                        p.getNombreProducto(),
                        p.getNombreMarca(),
                        p.getNombreCategoria(),
                        p.getPrecioEntrada(),
                        p.getUnidad(),
                        p.getStock()
                ))
                .collect(Collectors.toList());

        return new ListResponse<>(
                data,
                projections.getTotalElements(),
                projections.getTotalPages(),
                projections.getNumber() + 1
        );
    }

    private InventarioDTO convertToDTO(InventarioEntity inventarioEntity) {
        return modelMapper.map(inventarioEntity, InventarioDTO.class);
    }

}
