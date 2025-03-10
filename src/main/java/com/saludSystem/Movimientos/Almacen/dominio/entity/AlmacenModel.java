package com.saludSystem.Movimientos.Almacen.dominio.entity;

import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Generals.adapter.Sucursal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "almacenes")
public class AlmacenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "almacen_id", nullable = false, unique = true)
    private UUID almacenId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", nullable = false)
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludModel hospital;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserModel user;
}
