package com.saludsystem.submodules.movimiento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Venta {

    private UUID ventaId;
    private String serie;
    private String secuencia;
    private LocalDate fecha;
    private String tipoBeneficiario;
    private String beneficiarioDocumento;
    private String beneficiarioDireccion;
    private UUID tipoPagoId;
    private String observacion;
    private String metodoPago;
    private BigDecimal montoRecibido;
    private BigDecimal vuelto;
    private BigDecimal total;
    private UUID tipoDocumentoId;
    private UUID almacenId;
    private UUID beneficiarioId;
    private UUID tipoTarjetaId;
    private UUID tipoMonedaId;
    private Integer estado;

    private List<VentaDetalle> detalles;

}
