package com.saludsystem.submodules.movimiento.dtos.post;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class CrearVentaDTO {

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

    @Schema(description = "Estado de la venta (inactive = 0 / active = 1)", example = "0")
    private Integer estado;

    private List<CrearVentaDetalleDTO> detalle;

}