package com.saludSystem.application.dtos.Movimientos.PUT;

import com.saludSystem.application.dtos.Movimientos.GET.VentaDetalleDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ActualizarVentaDTO {

    private UUID hospitalId;
    private UUID userId;
    private UUID ventaId;
    private UUID tdocumentoId;
    private UUID almacenId;
    private UUID beneficiarioId;
    private UUID tipoTarjetaId;
    private UUID tipoMonedaId;
    private String serie;
    private String secuencia;
    private LocalDate fecha;
    private String tipoBeneficiario;
    private String beneficiarioDocumento;
    private String beneficiarioDireccion;
    private UUID tipoPagoId;
    private String observacion;
    private String metodoPago;

    @Schema(example = "0")
    private BigDecimal montoRecibido;

    @Schema(example = "0")
    private BigDecimal vuelto;

    @Schema(example = "0")
    private BigDecimal total;

    @Schema(description = "Estado de la venta (0 = inactive / 1 = active)", example = "0")
    private Integer estado;

    private List<VentaDetalleDTO> detalle;

}