package com.saludSystem.application.services.Operaciones.impl;

import com.saludSystem.application.dtos.Operaciones.GET.ProductoDTO;
import com.saludSystem.application.dtos.Operaciones.POST.CrearProductoDTO;
import com.saludSystem.application.dtos.Operaciones.PUT.ActualizarProductoDTO;
import com.saludSystem.application.services.Operaciones.ProductoService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Operaciones.*;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.*;
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
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaMatRepository categoriaMatRepository;
    private final PresentacionReposirory presentacionReposirory;
    private final TipoMaterialRepository tipoMaterialRepository;
    private final UnidadRepository unidadRepository;
    private final ModelMapper modelMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, MarcaRepository marcaRepository, CategoriaMatRepository categoriaMatRepository, PresentacionReposirory presentacionReposirory, TipoMaterialRepository tipoMaterialRepository, UnidadRepository unidadRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaMatRepository = categoriaMatRepository;
        this.presentacionReposirory = presentacionReposirory;
        this.tipoMaterialRepository = tipoMaterialRepository;
        this.unidadRepository = unidadRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse saveProducto(CrearProductoDTO crearProductoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        ProductoEntity productoEntity = new ProductoEntity();
        productoEntity.setDescripcion(crearProductoDTO.getDescripcion());
        productoEntity.setNombre(crearProductoDTO.getNombre());
        productoEntity.setCodigo(crearProductoDTO.getCodigo());
        Optional<MarcaEntity> marcaEntity = marcaRepository.findById(crearProductoDTO.getMarcaMaterialesId());
        marcaEntity.ifPresent(productoEntity::setMarcaEntity);
        Optional<CategoriaMatEntity> categoriaMatEntity = categoriaMatRepository.findById(crearProductoDTO.getCategoriaMaterialId());
        categoriaMatEntity.ifPresent(productoEntity::setCategoriaMatEntity);
        Optional<PresentacionEntity> presentacionEntity = presentacionReposirory.findById(crearProductoDTO.getPresentacionId());
        presentacionEntity.ifPresent(productoEntity::setPresentacionEntity);
        Optional<TipoMaterialEntity> tipoMaterialEntity = tipoMaterialRepository.findById(crearProductoDTO.getTipoMaterialId());
        tipoMaterialEntity.ifPresent(productoEntity::setTipoMaterialEntity);
        Optional<UnidadEntity> unidadEntity = unidadRepository.findById(crearProductoDTO.getUnidadId());
        unidadEntity.ifPresent(productoEntity::setUnidadEntity);
        productoEntity.setPrecioCompra(crearProductoDTO.getPrecioCompra());
        productoEntity.setPrecioVenta(crearProductoDTO.getPrecioVenta());
        productoEntity.setStock(crearProductoDTO.getStock());
        productoEntity.setCodigoBarras(crearProductoDTO.getCodigoBarras());
        productoEntity.setLote(crearProductoDTO.getLote());
        productoEntity.setFecha(crearProductoDTO.getFecha());
        productoEntity.setEstadoVenta(crearProductoDTO.getEstadoVenta());
        productoEntity.setEstadoCompra(crearProductoDTO.getEstadoCompra());
        productoEntity.setEstadoProducto(crearProductoDTO.getEstadoProducto());
        productoEntity.setHospital(hospital);
        productoEntity.setUser(userEntity);
        productoRepository.save(productoEntity);
        return new ApiResponse(true, "Producto registrado correctamente");
    }

    @Override
    public ListResponse<ProductoDTO> getAllProducto(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<ProductoEntity> productoEntityPage = productoRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<ProductoDTO> data = productoEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, productoEntityPage.getTotalElements(), productoEntityPage.getTotalPages(), productoEntityPage.getNumber() + 1);
    }

    @Override
    public ProductoDTO getProductoById(UUID productoId) {
        ProductoEntity productoEntity = productoRepository.findById(productoId).orElseThrow(
                () -> new ResourceNotFoundException("Producto no encontrado"));
        return convertToDTO(productoEntity);
    }

    @Override
    public ApiResponse updateProducto(UUID productoId, ActualizarProductoDTO actualizarProductoDTO) {
        ProductoEntity productoEntity = productoRepository.findById(productoId).orElseThrow(
                () -> new ResourceNotFoundException("Producto no encontrado"));
        Optional.ofNullable(actualizarProductoDTO.getDescripcion()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getNombre()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setNombre);
        Optional.ofNullable(actualizarProductoDTO.getCodigo()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setCodigo);
        Optional.ofNullable(actualizarProductoDTO.getMarcaMaterialesId()).flatMap(marcaRepository::findById).ifPresent(productoEntity::setMarcaEntity);
        Optional.ofNullable(actualizarProductoDTO.getCategoriaMaterialId()).flatMap(categoriaMatRepository::findById).ifPresent(productoEntity::setCategoriaMatEntity);
        Optional.ofNullable(actualizarProductoDTO.getPresentacionId()).flatMap(presentacionReposirory::findById).ifPresent(productoEntity::setPresentacionEntity);
        Optional.ofNullable(actualizarProductoDTO.getTipoMaterialId()).flatMap(tipoMaterialRepository::findById).ifPresent(productoEntity::setTipoMaterialEntity);
        Optional.ofNullable(actualizarProductoDTO.getUnidadId()).flatMap(unidadRepository::findById).ifPresent(productoEntity::setUnidadEntity);
        Optional.ofNullable(actualizarProductoDTO.getPrecioCompra()).ifPresent(productoEntity::setPrecioCompra);
        Optional.ofNullable(actualizarProductoDTO.getPrecioVenta()).ifPresent(productoEntity::setPrecioVenta);
        Optional.ofNullable(actualizarProductoDTO.getStock()).ifPresent(productoEntity::setStock);
        Optional.ofNullable(actualizarProductoDTO.getCodigoBarras()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getLote()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getFecha()).ifPresent(productoEntity::setFecha);
        Optional.ofNullable(actualizarProductoDTO.getEstadoVenta()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getEstadoCompra()).filter(desc -> !desc.isBlank()).ifPresent(productoEntity::setDescripcion);
        Optional.ofNullable(actualizarProductoDTO.getEstadoProducto()).ifPresent(productoEntity::setEstadoProducto);
        productoRepository.save(productoEntity);
        return new ApiResponse(true, "Producto actualizado correctamente");
    }

    @Override
    public ApiResponse deleteProducto(UUID productoId) {
        productoRepository.deleteById(productoId);
        return new ApiResponse(true, "Producto eliminado correctamente");
    }

    private ProductoDTO convertToDTO(ProductoEntity productoEntity) {
        return modelMapper.map(productoEntity, ProductoDTO.class);
    }

}