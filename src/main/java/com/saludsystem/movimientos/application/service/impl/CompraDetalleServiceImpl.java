package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.get.CompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.put.ActualizarCompraDetalleDTO;
import com.saludsystem.movimientos.application.service.CompraDetalleService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.movimientos.domain.model.CompraDetalleEntity;
import com.saludsystem.operaciones.domain.model.ProductoEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.CompraDetalleRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import static com.saludsystem.shared.infrastructure.constants.ErrorMessage.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompraDetalleServiceImpl implements CompraDetalleService {

    private final CompraDetalleRepository compraDetalleRepository;
    private final SysSaludRepository sysSaludRepository;
    private final AuthValidator authValidator;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public CompraDetalleServiceImpl(CompraDetalleRepository compraDetalleRepository, SysSaludRepository sysSaludRepository, AuthValidator authValidator, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.compraDetalleRepository = compraDetalleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.authValidator = authValidator;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCompraDetalle(CompraDetalleDTO compraDetalleDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CompraDetalleEntity compraDetalleEntity = new CompraDetalleEntity();
        Optional<ProductoEntity> productoEntity = productoRepository.findById(compraDetalleDTO.getProductoId());
        productoEntity.ifPresent(compraDetalleEntity::setProductoEntity);
        compraDetalleEntity.setCantidad(compraDetalleDTO.getCantidad());
        compraDetalleEntity.setPrecioUnitario(compraDetalleDTO.getPrecioUnitario());
        compraDetalleEntity.setIgv(compraDetalleDTO.getIgv());
        compraDetalleEntity.setPrecioVenta(compraDetalleDTO.getPrecioVenta());
        compraDetalleEntity.setSubtotal(compraDetalleDTO.getSubtotal());
        compraDetalleEntity.setUser(user);
        compraDetalleEntity.setHospital(hospital);
        compraDetalleRepository.save(compraDetalleEntity);
        return new ApiResponse(true, "Compra detalle agregada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateCompraDetalle(UUID compraDetalleId, ActualizarCompraDetalleDTO actualizarCompraDetalleDTO) {
        authValidator.validateAdminAccess();
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException(COMPRA_DETALLE_NOT_FOUND));
        Optional.ofNullable(actualizarCompraDetalleDTO.getProductoId()).
                flatMap(productoRepository::findById).ifPresent(compraDetalleEntity::setProductoEntity);
        Optional.ofNullable(actualizarCompraDetalleDTO.getCantidad()).ifPresent(compraDetalleEntity::setCantidad);
        Optional.ofNullable(actualizarCompraDetalleDTO.getPrecioUnitario()).ifPresent(compraDetalleEntity::setPrecioUnitario);
        Optional.ofNullable(actualizarCompraDetalleDTO.getIgv()).ifPresent(compraDetalleEntity::setIgv);
        Optional.ofNullable(actualizarCompraDetalleDTO.getPrecioVenta()).ifPresent(compraDetalleEntity::setPrecioVenta);
        Optional.ofNullable(actualizarCompraDetalleDTO.getSubtotal()).ifPresent(compraDetalleEntity::setSubtotal);
        compraDetalleRepository.save(compraDetalleEntity);
        return new ApiResponse(true, "Compra detalle actualizada correctamente");
    }

    @Override
    public CrearCompraDetalleDTO getCompraDetalleById(UUID compraDetalleId) {
        CompraDetalleEntity compraDetalleEntity = compraDetalleRepository.findById(compraDetalleId).orElseThrow(
                () -> new ResourceNotFoundException(COMPRA_DETALLE_NOT_FOUND));
        return convertToDto(compraDetalleEntity);
    }

    @Override
    public ListResponse<CrearCompraDetalleDTO> getAllCompraDetalle(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraDetalleEntity> compraDetalleEntityPage = compraDetalleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CrearCompraDetalleDTO> data = compraDetalleEntityPage.getContent().stream().map(this::convertToDto).toList();
        return new ListResponse<>(data, compraDetalleEntityPage.getTotalElements(), compraDetalleEntityPage.getTotalPages(), compraDetalleEntityPage.getNumber() + 1);
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteCompraDetalle(UUID compraDetalleId) {
        authValidator.validateAdminAccess();
        compraDetalleRepository.deleteById(compraDetalleId);
        return new ApiResponse(true, "Compra detalle retirada correctamente");
    }

    private CrearCompraDetalleDTO convertToDto(CompraDetalleEntity compraDetalleEntity) {
        return modelMapper.map(compraDetalleEntity, CrearCompraDetalleDTO.class);
    }
}