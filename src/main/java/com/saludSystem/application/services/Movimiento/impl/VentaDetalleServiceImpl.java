package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.VentaDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearVentaDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.PUT.ActualizarVentaDetalleDTO;
import com.saludSystem.application.services.Movimiento.VentaDetalleService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.VentaDetalleEntity;
import com.saludSystem.domain.model.Operaciones.ProductoEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.VentaDetalleRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaDetalleServiceImpl implements VentaDetalleService {

    private final VentaDetalleRepository ventaDetalleRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    public VentaDetalleServiceImpl(VentaDetalleRepository ventaDetalleRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.ventaDetalleRepository = ventaDetalleRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.productoRepository = productoRepository;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveVentaDetalle(CrearVentaDetalleDTO crearVentaDetalleDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId())
                .orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        VentaDetalleEntity ventaDetalleEntity = new VentaDetalleEntity();
        Optional<ProductoEntity> productoEntity = productoRepository.findById(crearVentaDetalleDTO.getProductoId());
        productoEntity.ifPresent(ventaDetalleEntity::setProductoEntity);
        ventaDetalleEntity.setCodigoProducto(crearVentaDetalleDTO.getCodigoProducto());
        ventaDetalleEntity.setCantidad(crearVentaDetalleDTO.getCantidad());
        ventaDetalleEntity.setPrecio(BigDecimal.valueOf(crearVentaDetalleDTO.getPrecioUnitario()));
        ventaDetalleEntity.setSubtotal(BigDecimal.valueOf(crearVentaDetalleDTO.getSubtotal()));
        ventaDetalleEntity.setHospital(hospital);
        ventaDetalleEntity.setUser(userEntity);
        ventaDetalleRepository.save(ventaDetalleEntity);
        return new ApiResponse(true, "Detalle de venta crada correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse deleteVentaDetalle(UUID ventaDetalleId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        ventaDetalleRepository.deleteById(ventaDetalleId);
        return new ApiResponse(true, "Detalle de venta eliminado correctamente");
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse updateVentaDetalle(UUID ventaDetalleId, ActualizarVentaDetalleDTO actualizarVentaDetalleDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        VentaDetalleEntity ventaDetalleEntity = ventaDetalleRepository.findById(ventaDetalleId).orElseThrow(() -> new ResourceNotFoundException("Detalle de venta no econtrado"));
        Optional.ofNullable(actualizarVentaDetalleDTO.getProductoId()).flatMap(productoRepository::findById).ifPresent(ventaDetalleEntity::setProductoEntity);
        Optional.ofNullable(actualizarVentaDetalleDTO.getCantidad()).ifPresent(ventaDetalleEntity::setCantidad);
        Optional.ofNullable(actualizarVentaDetalleDTO.getCodigoProducto()).filter(desc -> !desc.isBlank()).ifPresent(ventaDetalleEntity::setCodigoProducto);
        Optional.ofNullable(actualizarVentaDetalleDTO.getPrecioUnitario()).ifPresent(precio -> ventaDetalleEntity.setPrecio(BigDecimal.valueOf(precio)));
        Optional.ofNullable(actualizarVentaDetalleDTO.getSubtotal()).ifPresent(subtotal -> ventaDetalleEntity.setSubtotal(BigDecimal.valueOf(subtotal)));
        ventaDetalleRepository.save(ventaDetalleEntity);
        return new ApiResponse(true, "Detalle de venta actualizado correctamente");
    }

    @Override
    public VentaDetalleDTO getVentaDetalleById(UUID ventaDetalleId) {
        VentaDetalleEntity ventaDetalleEntity = ventaDetalleRepository.findById(ventaDetalleId).orElseThrow(() -> new ResourceNotFoundException("Detalle de venta no econtrado"));
        return convertToDTO(ventaDetalleEntity);
    }

    @Override
    public ListResponse<VentaDetalleDTO> getAllVentaDetalle(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<VentaDetalleEntity> ventaDetalleEntityPage = ventaDetalleRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<VentaDetalleDTO> data = ventaDetalleEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, ventaDetalleEntityPage.getTotalElements(), ventaDetalleEntityPage.getTotalPages(), ventaDetalleEntityPage.getNumber() + 1);
    }

    private VentaDetalleDTO convertToDTO(VentaDetalleEntity ventaDetalleEntity) {
        return modelMapper.map(ventaDetalleEntity, VentaDetalleDTO.class);
    }

}