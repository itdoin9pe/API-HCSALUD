package com.saludSystem.Generals.adapter;

import com.saludSystem.Configuracion.Sede.dominio.SedeModel;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Movimientos.Almacen.dominio.entity.AlmacenModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sucursal_id", nullable = false, unique = true)
    private UUID sucursalId;

    private String nombre;
    private String direccion;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludModel hospital;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<AlmacenModel> almacenes = new ArrayList<>();

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<SedeModel> sedes;

}