package com.saludsystem.submodules.core.configuracion.adapter.entity;

import com.saludsystem.submodules.core.principal.adapter.entity.MenuEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "permisos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermisoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID permisoId;

    @Column(name = "`delete`")
    private Boolean delete;

    @Column(name = "`insert`")
    private Boolean insert;

    @Column(name = "`read`")
    private Boolean read;

    @Column(name = "`update`")
    private Boolean update;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    private RoleEntity rol;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private MenuEntity menuEntity;

}