package com.saludsystem.submodules.movimiento.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
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

}
