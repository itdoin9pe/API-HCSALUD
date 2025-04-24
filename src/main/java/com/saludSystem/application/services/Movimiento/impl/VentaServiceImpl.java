package com.saludSystem.application.services.Movimiento.impl;

import com.saludSystem.application.dtos.Movimientos.GET.VentaByIdDTO;
import com.saludSystem.application.dtos.Movimientos.GET.VentaDTO;
import com.saludSystem.application.dtos.Movimientos.GET.VentaDetalleDTO;
import com.saludSystem.application.dtos.Movimientos.POST.CrearVentaDTO;
import com.saludSystem.application.services.Movimiento.VentaService;
import com.saludSystem.domain.exception.ResourceNotFoundException;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.Movimientos.VentaDetalleEntity;
import com.saludSystem.domain.model.Movimientos.VentaEntity;
import com.saludSystem.domain.model.Principal.PacienteEntity;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.SysSaludRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.TipoDocumentoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Configuracion.UserRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.MonedaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoPagoRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Mantenimiento.TipoTarjetaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.AlmacenRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Movimiento.VentaRepository;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final UserRepository userRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final AlmacenRepository almacenRepository;
    private final PacienteRepository pacienteRepository;
    private final TipoPagoRepository tipoPagoRepository;
    private final TipoTarjetaRepository tipoTarjetaRepository;
    private final MonedaRepository monedaRepository;
    private final ProductoRepository productoRepository;


    public VentaServiceImpl(VentaRepository ventaRepository, SysSaludRepository sysSaludRepository, UserRepository userRepository, TipoDocumentoRepository tipoDocumentoRepository, AlmacenRepository almacenRepository, PacienteRepository pacienteRepository, TipoPagoRepository tipoPagoRepository, TipoTarjetaRepository tipoTarjetaRepository, MonedaRepository monedaRepository, ProductoRepository productoRepository) {
        this.ventaRepository = ventaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.userRepository = userRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.almacenRepository = almacenRepository;
        this.pacienteRepository = pacienteRepository;
        this.tipoPagoRepository = tipoPagoRepository;
        this.tipoTarjetaRepository = tipoTarjetaRepository;
        this.monedaRepository = monedaRepository;
        this.productoRepository = productoRepository;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveVenta(CrearVentaDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        UserEntity userEntity = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!"ADMINISTRADOR".equals(userEntity.getRol().getNombre())) {
            return new ApiResponse(false, "No tienes permisos para realizar esta acción");
        }
        SysSaludEntity hospital = sysSaludRepository.findById(userEntity.getHospital().getHospitalId()).orElseThrow(() -> new RuntimeException("Hospital no encontrado"));
        VentaEntity venta = new VentaEntity();
        venta.setSerie(dto.getSerie());
        venta.setSecuencia(dto.getSecuencia());
        venta.setFecha(dto.getFecha());
        venta.setTipoBeneficiario(dto.getTipoBeneficiario());
        venta.setBeneficiarioDocumento(dto.getBeneficiarioDocumento());
        venta.setBeneficiarioDireccion(dto.getBeneficiarioDireccion());
        venta.setObservacion(dto.getObservacion());
        venta.setMetodoPago(dto.getMetodoPago());
        venta.setMontoRecibido(dto.getMontoRecibido());
        venta.setVuelto(dto.getVuelto());
        venta.setTotal(dto.getTotal());
        venta.setEstado(dto.getEstado());
        venta.setHospital(hospital);
        venta.setUser(userEntity);
        venta.setTipoDocumentoEntity(tipoDocumentoRepository.findById(dto.getTdocumentoId()).orElseThrow(() -> new ResourceNotFoundException("TipoDocumento no encontrado")));
        venta.setAlmacenEntity(almacenRepository.findById(dto.getAlmacenId()).orElseThrow(() -> new ResourceNotFoundException("Almacen no encontrado")));
        venta.setBeneficiarioId(pacienteRepository.findById(dto.getBeneficiarioId()).orElseThrow(() -> new ResourceNotFoundException("Paciente con no encontrad")));
        venta.setTipoTarjetaEntity(tipoTarjetaRepository.findById(dto.getTipoTarjetaId()).orElseThrow(() -> new ResourceNotFoundException("TipoTarjeta con id encontrado")));
        venta.setTipoMonedaEntity(monedaRepository.findById(dto.getTipoMonedaId()).orElseThrow(() -> new ResourceNotFoundException("Moneda no encontrado")));
        venta.setTipoPagoEntity(tipoPagoRepository.findById(dto.getTipoPagoId()).orElseThrow(() -> new ResourceNotFoundException("TipoPago no encontrado")));
        List<VentaDetalleEntity> detalles = dto.getDetalle().stream().map(det -> {
            VentaDetalleEntity detalle = new VentaDetalleEntity();
            detalle.setProductoEntity(productoRepository.findById(det.getProductoId()).orElseThrow(() -> new ResourceNotFoundException("Producto con id" + det.getProductoId())));
            detalle.setCodigoProducto(det.getCodigoProducto());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecio(BigDecimal.valueOf(det.getPrecioUnitario()));
            detalle.setSubtotal(BigDecimal.valueOf(det.getSubtotal()));
            detalle.setVentaEntity(venta);
            detalle.setHospital(hospital);
            detalle.setUser(userEntity);
            return detalle;
        }).collect(Collectors.toList());
        venta.setDetalle(detalles);
        ventaRepository.save(venta);
        return new ApiResponse(true, "Venta agregada correctamente");
    }

    @Override
    public List<VentaDTO> getVentaList() {
        return ventaRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public VentaByIdDTO getVentaById(UUID ventaId) {
        VentaEntity ventaEntity = ventaRepository.findById(ventaId).orElseThrow(() -> new ResourceNotFoundException("Venta con id " + ventaId + " no encontrada"));
        return convertToDetailedDTO(ventaEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<VentaEntity> ventaEntityPage = ventaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<VentaDTO> data = ventaEntityPage.getContent().stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ListResponse<>(data, ventaEntityPage.getTotalElements(), ventaEntityPage.getTotalPages(), ventaEntityPage.getNumber() + 1);
    }

    @Override
    public ApiResponse deleteVenta(UUID ventaId) {
        ventaRepository.deleteById(ventaId);
        return new ApiResponse(true, "Venta eliminada correctamente");
    }

    private VentaDTO convertToDTO(VentaEntity ventaEntity) {
        VentaDTO dto = new VentaDTO();
        dto.setVentaId(ventaEntity.getVentaId());
        // Tipo Documento
        if (ventaEntity.getTipoDocumentoEntity() != null) {
            dto.setTdocumentoId(ventaEntity.getTipoDocumentoEntity().getTDocumentoId());
            dto.setNombreTipoDocumento(ventaEntity.getTipoDocumentoEntity().getTDocumentoId().toString());
            dto.setNombreTipoDocumento(ventaEntity.getTipoDocumentoEntity().getTipoComprobante());
        }
        // Información básica de la venta
        dto.setSerie(ventaEntity.getSerie());
        dto.setSecuencia(ventaEntity.getSecuencia());
        dto.setFecha(ventaEntity.getFecha());
        // Almacén
        if (ventaEntity.getAlmacenEntity() != null) {
            dto.setAlmacenId(ventaEntity.getAlmacenEntity().getAlmacenId());
        }
        // Información del beneficiario
        dto.setTipoBeneficiario(ventaEntity.getTipoBeneficiario());
        if (ventaEntity.getBeneficiarioId() != null) {
            PacienteEntity paciente = ventaEntity.getBeneficiarioId();
            dto.setBeneficiarioId(paciente.getPacienteId());
            dto.setBeneficiarioId(paciente.getPacienteId());
            dto.setNombreBeneficiario(paciente.getNombres());
            dto.setApellidoBeneficiario(paciente.getApellidos());
        }
        dto.setBeneficiarioDocumento(ventaEntity.getBeneficiarioDocumento());
        dto.setBeneficiarioDireccion(ventaEntity.getBeneficiarioDireccion());
        // Tipo de pago
        if (ventaEntity.getTipoPagoEntity() != null) {
            dto.setTipoPagoId(ventaEntity.getTipoPagoEntity().getTipoPagoId());
            //dto.setTipoPagoId(ventaEntity.getTipoPagoEntity().getNombre());
        }
        dto.setObservacion(ventaEntity.getObservacion());
        dto.setMetodoPago(ventaEntity.getMetodoPago());
        // Tipo de tarjeta
        if (ventaEntity.getTipoTarjetaEntity() != null) {
            dto.setTipoTarjetaId(ventaEntity.getTipoTarjetaEntity().getTipoTarjetaId());
            //dto.setTipoTarjetaId(ventaEntity.getTipoTarjetaEntity().getTipoTarjetaId().toString());
        }
        dto.setMontoRecibido(ventaEntity.getMontoRecibido());
        // Tipo de moneda
        if (ventaEntity.getTipoMonedaEntity() != null) {
            dto.setTipoMonedaId(ventaEntity.getTipoMonedaEntity().getMonedaId());
            //dto.setTipoMonedaId(ventaEntity.getTipoMonedaEntity().getMonedaId().toString());
        }
        dto.setVuelto(ventaEntity.getVuelto());
        dto.setTotal(ventaEntity.getTotal());
        // Estado (asumiendo que existe este campo en la entidad)
        dto.setEstado(ventaEntity.getEstado());
        return dto;
    }

    private VentaByIdDTO convertToDetailedDTO(VentaEntity ventaEntity) {
        VentaByIdDTO dto = new VentaByIdDTO();
        // Datos básicos
        dto.setVentaId(ventaEntity.getVentaId());
        dto.setHospitalId(ventaEntity.getHospital().getHospitalId());
        dto.setUserId(ventaEntity.getUser().getUserId());
        // Tipo Documento
        if (ventaEntity.getTipoDocumentoEntity() != null) {
            dto.setTdocumentoId(ventaEntity.getTipoDocumentoEntity().getTDocumentoId());
        }
        // Almacén
        if (ventaEntity.getAlmacenEntity() != null) {
            dto.setAlmacenId(ventaEntity.getAlmacenEntity().getAlmacenId());
        }
        // Beneficiario
        if (ventaEntity.getBeneficiarioId() != null) {
            dto.setBeneficiarioId(ventaEntity.getBeneficiarioId().getPacienteId());
        }
        // Tipo de tarjeta
        if (ventaEntity.getTipoTarjetaEntity() != null) {
            dto.setTipoTarjetaId(ventaEntity.getTipoTarjetaEntity().getTipoTarjetaId());
        }
        // Tipo de moneda
        if (ventaEntity.getTipoMonedaEntity() != null) {
            dto.setTipoMonedaId(ventaEntity.getTipoMonedaEntity().getMonedaId());
        }
        // Tipo de pago
        if (ventaEntity.getTipoPagoEntity() != null) {
            dto.setTipoPagoId(ventaEntity.getTipoPagoEntity().getTipoPagoId());
        }
        // Datos de la venta
        dto.setSerie(ventaEntity.getSerie());
        dto.setSecuencia(ventaEntity.getSecuencia());
        dto.setFecha(ventaEntity.getFecha());
        dto.setTipoBeneficiario(ventaEntity.getTipoBeneficiario());
        dto.setBeneficiarioDocumento(ventaEntity.getBeneficiarioDocumento());
        dto.setBeneficiarioDireccion(ventaEntity.getBeneficiarioDireccion());
        dto.setObservacion(ventaEntity.getObservacion());
        dto.setMetodoPago(ventaEntity.getMetodoPago());
        dto.setMontoRecibido(ventaEntity.getMontoRecibido());
        dto.setVuelto(ventaEntity.getVuelto());
        dto.setTotal(ventaEntity.getTotal());
        dto.setEstado(ventaEntity.getEstado());
        // Detalles de la venta
        if (ventaEntity.getDetalle() != null) {
            List<VentaDetalleDTO> detallesDTO = ventaEntity.getDetalle().stream().map(this::convertDetalleToDTO).collect(Collectors.toList());dto.setDetalle(detallesDTO);
        }
        return dto;
    }

    private VentaDetalleDTO convertDetalleToDTO(VentaDetalleEntity detalleEntity) {
        VentaDetalleDTO dto = new VentaDetalleDTO();
        dto.setVentaDetalleId(detalleEntity.getVentaDetalleId());
        if (detalleEntity.getProductoEntity() != null) {
            dto.setProductoId(detalleEntity.getProductoEntity().getProductoId());
        }
        if (detalleEntity.getVentaEntity() != null) {
            dto.setVentaId(detalleEntity.getVentaEntity().getVentaId());
        }
        dto.setCodigoProducto(detalleEntity.getCodigoProducto());
        dto.setCantidad(detalleEntity.getCantidad());
        dto.setPrecioUnitario(detalleEntity.getPrecio().doubleValue());
        dto.setSubtotal(detalleEntity.getSubtotal().doubleValue());
        return dto;
    }
}