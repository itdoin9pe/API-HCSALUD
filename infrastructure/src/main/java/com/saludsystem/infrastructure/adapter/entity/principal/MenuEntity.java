package com.saludsystem.infrastructure.adapter.entity.principal;

import com.configuracion.domain.model.PermisoEntity;
import com.configuracion.domain.model.SysSaludEntity;
import com.configuracion.domain.model.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "menus")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "menu_id", nullable = false, unique = true)
    private UUID menuId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ruta", nullable = false)
    private String ruta;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludEntity hospital;

    @OneToMany(mappedBy = "menuEntity")
    private List<PermisoEntity> permisoEntities;

}