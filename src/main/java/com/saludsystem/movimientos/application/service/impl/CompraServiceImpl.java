package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.post.CrearCompraDTO;
import com.saludsystem.movimientos.application.dto.post.CrearCompraDetalleDTO;
import com.saludsystem.movimientos.application.dto.get.CompraDTO;
import com.saludsystem.movimientos.application.service.CompraService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.movimientos.domain.model.CompraDetalleEntity;
import com.saludsystem.movimientos.domain.model.CompraEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoPagoRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.CompraRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProveedorRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final SysSaludRepository sysSaludRepository;
    private final ProveedorRepository proveedorRepository;
    private final ProductoRepository productoRepository;
    private final TipoPagoRepository tipoPagoRepository;
    private final AlmacenRepository almacenRepository;
    private final ModelMapper modelMapper;
    private final AuthValidator authValidator;

    public CompraServiceImpl(CompraRepository compraRepository, SysSaludRepository sysSaludRepository, ProveedorRepository proveedorRepository, ProductoRepository productoRepository, TipoPagoRepository tipoPagoRepository, AlmacenRepository almacenRepository, ModelMapper modelMapper, AuthValidator authValidator) {
        this.compraRepository = compraRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.proveedorRepository = proveedorRepository;
        this.productoRepository = productoRepository;
        this.tipoPagoRepository = tipoPagoRepository;
        this.almacenRepository = almacenRepository;
        this.modelMapper = modelMapper;
        this.authValidator = authValidator;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveCompra(CompraDTO compraDTO) {
        authValidator.validateAdminAccess();
        var user = authValidator.getCurrentUser();
        var hospital = sysSaludRepository.findById(user.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CompraEntity compra = new CompraEntity();
        compra.setFecha(compraDTO.getFecha());
        compra.setTipoDocumento(compraDTO.getTipoDocumento());
        compra.setNroDocumento(compraDTO.getNroDocumento());
        compra.setProveedorEntity(proveedorRepository.findById(compraDTO.getProveedorId()).orElseThrow( () -> new ResourceNotFoundException("Proveedor no encontrado")));
        compra.setTipoPagoEntity(tipoPagoRepository.findById(compraDTO.getTipoPagoId()).orElseThrow( () -> new ResourceNotFoundException("Tipo de pago no encontrado")));
        compra.setAlmacenEntity(almacenRepository.findById(compraDTO.getAlmacenId()).orElseThrow( () -> new ResourceNotFoundException("Almacen no encontrado")));
        compra.setEfectivo_total(compraDTO.getEfectivo());
        compra.setGuiaRemision(compraDTO.getGuiaRemision());
        compra.setObservacion(compraDTO.getObservacion());
        compra.setEstado(compraDTO.getEstado());
        compra.setHospital(hospital);
        compra.setUser(user);
        List<CompraDetalleEntity> detalles = compraDTO.getDetalles().stream().map(det ->{
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
    public ListResponse<CrearCompraDTO> getAllCompra(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraEntity> compraEntityPage = compraRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CrearCompraDTO> data = compraEntityPage.getContent().stream().map(this::convertToDTOById).toList();
        return new ListResponse<>(data, compraEntityPage.getTotalElements(), compraEntityPage.getTotalPages(), compraEntityPage.getNumber() + 1);
    }

    @Override
    public CrearCompraDTO getCompraById(UUID compraId) {
        CompraEntity compraEntity = compraRepository.findById(compraId).orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
        return convertToDTOById(compraEntity);
    }

    private CrearCompraDTO convertToDTOById(CompraEntity compraEntity) {
        return modelMapper.map(compraEntity, CrearCompraDTO.class);
    }

    private CrearCompraDetalleDTO convertDetalleToDTO(CompraDetalleEntity detalleEntity) {
        CrearCompraDetalleDTO dto = new CrearCompraDetalleDTO();
        //dto.setCompraDetalleId(detalleEntity.getCompraDetalleId());
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