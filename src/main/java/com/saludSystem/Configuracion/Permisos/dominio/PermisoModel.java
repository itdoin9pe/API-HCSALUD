package com.saludSystem.Configuracion.Permisos.dominio;

import com.saludSystem.Configuracion.Roles.dominio.RoleModel;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Generals.adapter.Menu.domain.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "permisos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermisoModel {

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
    private RoleModel rol;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludModel hospital;

}