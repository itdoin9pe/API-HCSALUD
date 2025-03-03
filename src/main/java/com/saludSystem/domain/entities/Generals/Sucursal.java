package com.saludSystem.domain.entities.Generals;

import com.saludSystem.domain.entities.Movimientos.Almacen;
import com.saludSystem.domain.entities.configuracion.Sede;
import com.saludSystem.domain.entities.configuracion.SysSalud;
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
    private SysSalud hospital;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Almacen> almacenes = new ArrayList<>();

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Sede> sedes;

}