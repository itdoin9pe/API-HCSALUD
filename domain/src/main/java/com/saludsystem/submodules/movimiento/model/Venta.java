package com.saludsystem.submodules.movimiento.model;

import com.saludsystem.submodules.mantenimiento.model.Moneda;
import com.saludsystem.submodules.mantenimiento.model.TipoPago;
import com.saludsystem.submodules.mantenimiento.model.TipoTarjeta;
import com.saludsystem.submodules.medico.model.vo.TipoDocumento;
import com.saludsystem.submodules.paciente.model.entity.Paciente;
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
    private TipoPago tipoPago;
    private String observacion;
    private String metodoPago;
    private BigDecimal montoRecibido;
    private BigDecimal vuelto;
    private BigDecimal total;
    private TipoDocumento tipoDocumento;
    private Almacen almacen;
    private Paciente beneficiario;
    private TipoTarjeta tipoTarjeta;
    private Moneda tipoMoneda;
    private List<VentaDetalle> detalle;
    private Integer estado;

}
