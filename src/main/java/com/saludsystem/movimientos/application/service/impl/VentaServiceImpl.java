package com.saludsystem.movimientos.application.service.impl;

import com.saludsystem.movimientos.application.dto.get.VentaDetalleDTO;
import com.saludsystem.movimientos.application.dto.post.CrearVentaDTO;
import com.saludsystem.movimientos.application.dto.get.VentaDTO;
import com.saludsystem.movimientos.application.dto.post.CrearVentaDetalleDTO;
import com.saludsystem.movimientos.application.service.VentaService;
import com.saludsystem.shared.domain.exception.ResourceNotFoundException;
import com.saludsystem.configuracion.domain.model.SysSaludEntity;
import com.saludsystem.movimientos.domain.model.VentaDetalleEntity;
import com.saludsystem.movimientos.domain.model.VentaEntity;
import com.saludsystem.paciente.domain.model.PacienteEntity;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.SysSaludRepository;
import com.saludsystem.configuracion.infrastructure.adapters.out.persistance.TipoDocumentoRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.MonedaRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoPagoRepository;
import com.saludsystem.mantenimiento.infrastructure.adapters.out.persistance.TipoTarjetaRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.AlmacenRepository;
import com.saludsystem.movimientos.infrastructure.adapters.out.persistance.VentaRepository;
import com.saludsystem.operaciones.infrastructure.adapters.out.persistance.ProductoRepository;
import com.saludsystem.paciente.infrastructure.adapters.out.persistance.PacienteRepository;
import com.saludsystem.shared.infrastructure.security.util.AuthValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.saludsystem.shared.infrastructure.constants.ErrorMessage.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VentaServiceImpl implements VentaService {

    private final VentaRepository ventaRepository;
    private final SysSaludRepository sysSaludRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final AlmacenRepository almacenRepository;
    private final PacienteRepository pacienteRepository;
    private final TipoPagoRepository tipoPagoRepository;
    private final TipoTarjetaRepository tipoTarjetaRepository;
    private final MonedaRepository monedaRepository;
    private final ProductoRepository productoRepository;
    private final AuthValidator authValidator;

    public VentaServiceImpl(VentaRepository ventaRepository, SysSaludRepository sysSaludRepository, TipoDocumentoRepository tipoDocumentoRepository, AlmacenRepository almacenRepository, PacienteRepository pacienteRepository, TipoPagoRepository tipoPagoRepository, TipoTarjetaRepository tipoTarjetaRepository, MonedaRepository monedaRepository, ProductoRepository productoRepository, AuthValidator authValidator) {
        this.ventaRepository = ventaRepository;
        this.sysSaludRepository = sysSaludRepository;
        this.tipoDocumentoRepository = tipoDocumentoRepository;
        this.almacenRepository = almacenRepository;
        this.pacienteRepository = pacienteRepository;
        this.tipoPagoRepository = tipoPagoRepository;
        this.tipoTarjetaRepository = tipoTarjetaRepository;
        this.monedaRepository = monedaRepository;
        this.productoRepository = productoRepository;
        this.authValidator = authValidator;
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @Override
    public ApiResponse saveVenta(CrearVentaDTO dto) {
        authValidator.validateAdminAccess(); // Lanza excepción si no es admin
        var user = authValidator.getCurrentUser();
        SysSaludEntity hospital = sysSaludRepository.findById(user.getHospital().getHospitalId()).orElseThrow(
                () -> new ResourceNotFoundException(VENTA_NOT_FOUND));
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
        venta.setUser(user);
        venta.setTipoDocumentoEntity(tipoDocumentoRepository.findById(dto.getTdocumentoId()).orElseThrow(() -> new ResourceNotFoundException(TIPO_DOCUMENTO_NOT_FOUND)));
        venta.setAlmacenEntity(almacenRepository.findById(dto.getAlmacenId()).orElseThrow(() -> new ResourceNotFoundException(ALMACEN_NOT_FOUND)));
        venta.setBeneficiarioId(pacienteRepository.findById(dto.getBeneficiarioId()).orElseThrow(() -> new ResourceNotFoundException(PACIENTE_NOT_FOUND)));
        venta.setTipoTarjetaEntity(tipoTarjetaRepository.findById(dto.getTipoTarjetaId()).orElseThrow(() -> new ResourceNotFoundException(TIPO_TARJETA_NOT_FOUND)));
        venta.setTipoMonedaEntity(monedaRepository.findById(dto.getTipoMonedaId()).orElseThrow(() -> new ResourceNotFoundException(MONEDA_NOT_FOUND)));
        venta.setTipoPagoEntity(tipoPagoRepository.findById(dto.getTipoPagoId()).orElseThrow(() -> new ResourceNotFoundException(TIPO_PAGO_NOT_FOUND)));
        List<VentaDetalleEntity> detalles = dto.getDetalle().stream().map(det -> {
            VentaDetalleEntity detalle = new VentaDetalleEntity();
            detalle.setProductoEntity(productoRepository.findById(det.getProductoId()).orElseThrow(() -> new ResourceNotFoundException(PRODUCTO_NOT_FOUND)));
            detalle.setCodigoProducto(det.getCodigoProducto());
            detalle.setCantidad(det.getCantidad());
            detalle.setPrecio(BigDecimal.valueOf(det.getPrecioUnitario()));
            detalle.setSubtotal(BigDecimal.valueOf(det.getSubtotal()));
            detalle.setVentaEntity(venta);
            detalle.setHospital(hospital);
            detalle.setUser(user);
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
    public VentaDTO getVentaById(UUID ventaId) {
        VentaEntity ventaEntity = ventaRepository.findById(ventaId).
                orElseThrow(() -> new ResourceNotFoundException(VENTA_NOT_FOUND));
        return convertToDetailedDTO(ventaEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public ListResponse<VentaDTO> getAllVenta(UUID hospitalId, int page, int rows) {
        Pageable pageable = PageRequest.of(page - 1, rows);
        Page<VentaEntity> ventaEntityPage = ventaRepository.findByHospital_HospitalId(hospitalId, pageable);
        List<VentaDTO> data = ventaEntityPage.getContent().stream().map(this::convertToDTO).toList();
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
        }
        dto.setMontoRecibido(ventaEntity.getMontoRecibido());
        // Tipo de moneda
        if (ventaEntity.getTipoMonedaEntity() != null) {
            dto.setTipoMonedaId(ventaEntity.getTipoMonedaEntity().getMonedaId());
        }
        dto.setVuelto(ventaEntity.getVuelto());
        dto.setTotal(ventaEntity.getTotal());
        // Estado (asumiendo que existe este campo en la entidad)
        dto.setEstado(ventaEntity.getEstado());
        return dto;
    }

    private VentaDTO convertToDetailedDTO(VentaEntity ventaEntity) {
        VentaDTO dto = new VentaDTO();
        // Datos básicos
        dto.setVentaId(ventaEntity.getVentaId());
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
            List<CrearVentaDetalleDTO> detallesDTO = ventaEntity.getDetalle()
                    .stream().map(this::convertDetalleToDTO)
                    .collect(Collectors.toList());dto.setDetalle(detallesDTO);
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