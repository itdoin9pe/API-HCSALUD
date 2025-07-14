package com.saludsystem.submodules.adapter.entity.principal;

import com.saludsystem.submodules.adapter.entity.configuracion.SedeEntity;
import com.saludsystem.submodules.adapter.entity.configuracion.SysSaludEntity;
import com.saludsystem.submodules.adapter.entity.movimiento.AlmacenEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursales")
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sucursal_id", nullable = false, unique = true)
    private UUID sucursalId;

    private String nombre;
    private String direccion;
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludEntity hospital;

    @OneToMany(mappedBy = "sucursalEntity", cascade = CascadeType.ALL)
    private List<AlmacenEntity> almacenes = new ArrayList<>();

    @OneToMany(mappedBy = "sucursalEntity", cascade = CascadeType.ALL)
    private List<SedeEntity> sedes;

}