package com.saludsystem.infrastructure.adapter.entity.operaciones;

import com.saludsystem.shared.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(callSuper = true)
public class ProveedorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "proveedor_id", nullable = false)
    private UUID proveedorId;

    @Column(name = "ruc_proveedor", nullable = false, unique = true)
    private String ruc;

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombre;

    @Column(name = "direccion_proveedor", nullable = false)
    private String direccion;

    @Column(name = "telefono_proveedor", nullable = false, unique = true)
    private String telefono;

    @Column(name = "correo_proveedor", nullable = false, unique = true)
    private String correo;

    @Column(name = "contacto_proveedor", nullable = false)
    private String contacto;

}