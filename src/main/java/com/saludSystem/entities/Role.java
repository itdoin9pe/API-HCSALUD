package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.Permiso;
import com.saludSystem.entities.configuracion.SysSalud;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rol_id", nullable = false, unique = true)
    private UUID roleId;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSalud hospital;

    @OneToMany(mappedBy = "rol")
    private List<User> usuarios;

    @OneToMany(mappedBy = "rol")
    private List<Permiso> permisos;

}