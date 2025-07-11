package com.saludsystem.infrastructure.adapter.entity.movimiento;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.configuracion.domain.model.SedeEntity;
import com.saludsystem.shared.domain.model.SucursalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "almacenes")
@EqualsAndHashCode(callSuper = true)
public class AlmacenEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "almacen_id", nullable = false, unique = true)
    private UUID almacenId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "id_sede", nullable = false)
    private SedeEntity sedeEntity;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private SucursalEntity sucursalEntity;

}