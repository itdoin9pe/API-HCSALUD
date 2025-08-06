package com.saludsystem.submodules.movimiento.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
public class Compra {

    private UUID compraId;
    private LocalDate fecha;
    private String tipoDocumento;
    private String nroDocumento;
    private UUID proveedorId;
    private UUID tipoPagoId;
    private UUID almacenId;
    private BigDecimal efectivoTotal;
    private String guiaRemision;
    private String observacion;
    private Integer estado;
    private List<CompraDetalle> detalles;

    public Compra() {}

    public Compra(UUID compraId, LocalDate fecha, String tipoDocumento, String nroDocumento,
                  UUID proveedorId, UUID tipoPagoId, UUID almacenId, BigDecimal efectivoTotal,
                  String guiaRemision, String observacion, Integer estado,
                  List<CompraDetalle> detalles) {
        this.compraId = compraId;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.proveedorId = proveedorId;
        this.tipoPagoId = tipoPagoId;
        this.almacenId = almacenId;
        this.efectivoTotal = efectivoTotal;
        this.guiaRemision = guiaRemision;
        this.observacion = observacion;
        this.estado = estado;
        this.detalles = detalles;
    }

}
