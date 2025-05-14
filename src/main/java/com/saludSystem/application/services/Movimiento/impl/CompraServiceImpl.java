package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.CompraDTO;
import com.saludSystem.application.dtos.Movimientos.GET.CompraDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearCompraDTO;
import com.saludSystem.application.services.Movimiento.CompraService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.CompraDetalleEntity;
import com.saludSystem.domain.model.Movimientos.CompraEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoPagoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.AlmacenRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.CompraRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProveedorRepository;
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
    public ApiResponse saveCompra(CrearCompraDTO crearCompraDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        CompraEntity compra = new CompraEntity();
        compra.setFecha(crearCompraDTO.getFecha());
        compra.setTipoDocumento(crearCompraDTO.getTipoDocumento());
        compra.setNroDocumento(crearCompraDTO.getNroDocumento());
        compra.setProveedorEntity(proveedorRepository.findById(crearCompraDTO.getProveedorId()).orElseThrow( () -> new ResourceNotFoundException("Proveedor no encontrado")));
        compra.setTipoPagoEntity(tipoPagoRepository.findById(crearCompraDTO.getTipoPagoId()).orElseThrow( () -> new ResourceNotFoundException("Tipo de pago no encontrado")));
        compra.setAlmacenEntity(almacenRepository.findById(crearCompraDTO.getAlmacenId()).orElseThrow( () -> new ResourceNotFoundException("Almacen no encontrado")));
        compra.setEfectivo_total(crearCompraDTO.getEfectivo());
        compra.setGuiaRemision(crearCompraDTO.getGuiaRemision());
        compra.setObservacion(crearCompraDTO.getObservacion());
        compra.setEstado(crearCompraDTO.getEstado());
        compra.setHospital(hospital);
        compra.setUser(userEntity);
        List<CompraDetalleEntity> detalles = crearCompraDTO.getDetalles().stream().map(det ->{
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
    public ListResponse<CompraDTO> getAllCompra(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<CompraEntity> compraEntityPage = compraRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<CompraDTO> data = compraEntityPage.getContent().stream().map(this::convertToDTOById).collect(Collectors.toList());
        return new ListResponse<>(data, compraEntityPage.getTotalElements(), compraEntityPage.getTotalPages(), compraEntityPage.getNumber() + 1);
    }

    @Override
    public CompraDTO getCompraById(UUID compraId) {
        CompraEntity compraEntity = compraRepository.findById(compraId).orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
        return convertToDTOById(compraEntity);
    }

    private CompraDTO convertToDTOById(CompraEntity compraEntity) {
        return modelMapper.map(compraEntity, CompraDTO.class);
    }

    private CompraDetalleDTO convertDetalleToDTO(CompraDetalleEntity detalleEntity) {
        CompraDetalleDTO dto = new CompraDetalleDTO();
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