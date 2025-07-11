package com.saludsystem.infrastructure.adapter.entity.mantenimiento;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tipos_pago")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class TipoPagoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_tipoPagos", nullable = false)
    private UUID tipoPagoId;

    @Column(name = "metodoPago", nullable = false)
    private String metodoPago;

    @Column(name = "descripcion_tipoPago", nullable = false)
    private String descripcion;

    @Column(name = "estado_tipoPago", nullable = false)
    private Integer estado;

}