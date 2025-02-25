package com.saludSystem.entities;

import com.saludSystem.entities.Movimientos.Almacen;
import com.saludSystem.entities.configuracion.SysSalud;
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
public class Sucursal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "sucursal_id", nullable = false, unique = true)
    private UUID sucursalId;

    private String nombre;
    private String direccion;
    private boolean isDefault;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Almacen> almacenes = new ArrayList<>();

}
