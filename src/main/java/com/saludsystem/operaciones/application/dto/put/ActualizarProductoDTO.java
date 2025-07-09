package com.saludsystem.operaciones.application.dto.put;

import com.saludsystem.shared.application.dto.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Data
public class ActualizarProductoDTO extends BaseDTO {

    private UUID productoId;
    private UUID marcaMaterialesId;
    private UUID tipoMaterialId;
    private UUID unidadId;
    private UUID presentacionId;
    private UUID categoriaMaterialId;
    private String codigo;
    private String codigoBarras;
    private String descripcion;
    private String lote;
    @Schema(example = "GzDSDmMeTlm xyYplI GZvAawakdKTmxrfavKQHeNKiPzv iKEwIMWSMQQ fglOJCDHZWCQBqCcXYNcI")
    private String nombre;
    @Schema(example = "2025-04-03T20:45:54.117Z")
    private LocalDate fecha;
    @Schema(description = "Estado de la venta del Producto", example = "0")
    private Integer stock;
    @Schema(description = "Estado de la venta del Producto", example = "0")
    private BigDecimal precioCompra;
    @Schema(description = "Estado de la venta del Producto", example = "0")
    private BigDecimal precioVenta;
    @Schema(description = "Estado del Producto (ACTIVO = 1 / INACTIVO = 0)", example = "0")
    private Integer estadoProducto;
    @Schema(description = "Estado de la venta del Producto (SI / NO)")
    private String estadoVenta;
    @Schema(description = "Estado de la compra del Producto (SI / NO)")
    private String estadoCompra;

}