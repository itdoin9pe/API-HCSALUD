package com.saludSystem.domain.model.Movimientos;

import com.saludSystem.domain.model.Configuracion.SedeEntity;
import com.saludSystem.domain.model.Configuracion.SysSaludEntity;
import com.saludSystem.domain.model.Configuracion.UserEntity;
import com.saludSystem.domain.model.SucursalEntity;
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
public class AlmacenEntity {

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

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludEntity hospital;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UserEntity user;

}