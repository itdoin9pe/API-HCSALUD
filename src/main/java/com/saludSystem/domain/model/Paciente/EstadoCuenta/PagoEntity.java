package com.saludSystem.domain.model.Paciente.EstadoCuenta;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pacientes_estados_cuentas_pagos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PagoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pago", nullable = false)
    private UUID idPago;

    @ManyToOne
    @JoinColumn(name = "id_estado_cuenta", nullable = false)
    private EstadoCuentaEntity estadoCuentaEntity;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago; // Ej: EFECTIVO, TARJETA, TRANSFERENCIA

    @Column(name = "referencia_pago")
    private String referenciaPago;

}