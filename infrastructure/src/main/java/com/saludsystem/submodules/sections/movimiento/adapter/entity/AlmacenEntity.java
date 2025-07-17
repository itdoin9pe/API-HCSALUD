package com.saludsystem.submodules.sections.movimiento.adapter.entity;

import com.saludsystem.submodules.sections.configuracion.adapter.entity.BaseEntity;
import com.saludsystem.submodules.sections.configuracion.adapter.entity.SedeEntity;
import com.saludsystem.submodules.sections.principal.adapter.entity.SucursalEntity;
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