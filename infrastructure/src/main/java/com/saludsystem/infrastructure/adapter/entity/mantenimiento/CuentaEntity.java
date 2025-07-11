package com.saludsystem.infrastructure.adapter.entity.mantenimiento;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "cuentas")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class CuentaEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cuentasPagar_id", nullable = false)
    private UUID cuentaPagarId;

    @Column(name = "nombre_cuenta", nullable = false, unique = true)
    private String nombre;

    @Column(name = "total_cuenta", nullable = false)
    private Integer total;

    @Column(name = "estado_cuenta", nullable = false)
    private Integer estado;

}