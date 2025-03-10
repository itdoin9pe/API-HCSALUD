package com.saludSystem.Configuracion.Roles.dominio;

import com.saludSystem.Configuracion.Permisos.dominio.PermisoModel;
import com.saludSystem.Configuracion.SysSalud.dominio.SysSaludModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {

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
    private SysSaludModel hospital;

    @OneToMany(mappedBy = "rol")
    private List<UserModel> usuarios;

    @OneToMany(mappedBy = "rol")
    private List<PermisoModel> permisos;

}