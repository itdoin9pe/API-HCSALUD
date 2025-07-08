package com.saludsystem.application.services.Movimiento.impl;


import com.saludsystem.movimientos.application.dto.res.CompraResponse;
import com.saludsystem.movimientos.application.dto.res.CompraDetalleResponse;
import com.saludsystem.movimientos.application.dto.req.CompraRequest;
import com.saludsystem.movimientos.application.service.CompraService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.configuracion.domain.model.UserEntity;
import com.saludsystem.movimientos.domain.model.CompraDetalleEntity;
import com.saludsystem.movimientos.domain.model.CompraEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.UserRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoPagoRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.CompraRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProveedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ProveedorRepository proveedorRepository;
    private final ProductoRepository productoRepository;
    private final TipoPagoRepository tipoPagoRepository;
    private final AlmacenRepository almacenRepository;
    private final ModelMapper modelMapper;

    public CompraServiceImpl(CompraRepository compraRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ProveedorRepository proveedorRepository, ProductoRepository productoRepository, TipoPagoRepository tipoPagoRepository, AlmacenRepository almacenRepository, ModelMapper modelMapper) {
        this.compraRepository = compraRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.proveedorRepository = proveedorRepository;
        this.productoRepository = productoRepository;
        this.tipoPagoRepository = tipoPagoRepository;
        this.almacenRepository = almacenRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCompra(CompraRequest compraRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CompraEntity compra = new CompraEntity();
        compra.setFecha(compraRequest.getFecha());
        compra.setTipoDocumento(compraRequest.getTipoDocumento());
        compra.setNroDocumento(compraRequest.getNroDocumento());
        compra.setProveedorEntity(proveedorRepository.findById(compraRequest.getProveedorId()).orElseThrow( () -> new ResourceNotFoundException("Proveedor no encontrado")));
        compra.setTipoPagoEntity(tipoPagoRepository.findById(compraRequest.getTipoPagoId()).orElseThrow( () -> new ResourceNotFoundException("Tipo de pago no encontrado")));
        compra.setAlmacenEntity(almacenRepository.findById(compraRequest.getAlmacenId()).orElseThrow( () -> new ResourceNotFoundException("Almacen no encontrado")));
        compra.setEfectivo_total(compraRequest.getEfectivo());
        compra.setGuiaRemision(compraRequest.getGuiaRemision());
        compra.setObservacion(compraRequest.getObservacion());
        compra.setEstado(compraRequest.getEstado());
        compra.setHospital(hospital);
        compra.setUser(userEntity);
        List<CompraDetalleEntity> detalles = compraRequest.getDetalles().stream().map(det ->{
            CompraDetalleEntity detalle = new CompraDetalleEntity();
            detalle.setProductoEntity(productoRepository.findById(det.getProductoId()).orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado")));
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecioUnitario(det.getPrecioUnitario());
            detalle.setIgv(det.getIgv());
            detalle.setPrecioVenta(det.getPrecioVenta());
            detalle.setSubtotal(det.getSubtotal());
            return detalle;
        }).collect(Collectors.toList());
        compra.setDetalle(detalles);
        compraRepository.save(compra);
        return new ApiResponse(true, "Compra agredada correctamente");
    }

    @Override
    public ApiResponse deleteCompra(UUID compraId) {
        compraRepository.deleteById(compraId);
        return new ApiResponse(true, "Compra actualizada correctamente");
    }

    @Override
    public ListResponse<CompraResponse> getAllCompra(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraEntity> compraEntityPage = compraRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CompraResponse> data = compraEntityPage.getContent().stream().map(this::convertToDTOById).collect(Collectors.toList());
        return new ListResponse<>(data, compraEntityPage.getTotalElements(), compraEntityPage.getTotalPages(), compraEntityPage.getNumber() + 1);
    }

    @Override
    public CompraResponse getCompraById(UUID compraId) {
        CompraEntity compraEntity = compraRepository.findById(compraId).orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
        return convertToDTOById(compraEntity);
    }

    private CompraResponse convertToDTOById(CompraEntity compraEntity) {
        return modelMapper.map(compraEntity, CompraResponse.class);
    }

    private CompraDetalleResponse convertDetalleToDTO(CompraDetalleEntity detalleEntity) {
        CompraDetalleResponse dto = new CompraDetalleResponse();
        dto.setCompraDetalleId(detalleEntity.getCompraDetalleId());
        if (detalleEntity.getProductoEntity() != null) {
            dto.setProductoId(detalleEntity.getProductoEntity().getProductoId());
        }
        if (detalleEntity.getCompraEntity() != null) {
            dto.setCompraId(detalleEntity.getCompraEntity().getCompraId());
        }
        dto.setCantidad(detalleEntity.getCantidad());
        dto.setPrecioUnitario(detalleEntity.getPrecioUnitario());
        dto.setIgv(detalleEntity.getIgv());
        dto.setPrecioVenta(detalleEntity.getPrecioVenta());
        dto.setSubtotal(detalleEntity.getSubtotal());
        return dto;
    }

}