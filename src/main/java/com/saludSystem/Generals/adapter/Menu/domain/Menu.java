package com.saludSystem.Generals.adapter.Menu.domain;

import com.saludSystem.Configuracion.Permisos.dominio.PermisoModel;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
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
public class Menu {

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
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSaludModel hospital;

    @OneToMany(mappedBy = "menu")
    private List<PermisoModel> permisos;

}