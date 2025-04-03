package com.saludSystem.domain.model.Operaciones;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
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