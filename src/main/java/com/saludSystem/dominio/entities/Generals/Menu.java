package com.saludSystem.dominio.entities.Generals;

import com.saludSystem.dominio.entities.Configuracion.User;
import com.saludSystem.dominio.entities.Configuracion.Permiso;
import com.saludSystem.dominio.entities.Configuracion.SysSalud;
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
    private User user;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSalud hospital;

    @OneToMany(mappedBy = "menu")
    private List<Permiso> permisos;

}