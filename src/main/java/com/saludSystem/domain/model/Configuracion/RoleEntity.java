package com.saludSystem.domain.model.Configuracion;

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
public class RoleEntity {

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
    private SysSaludEntity hospital;

    @OneToMany(mappedBy = "rol")
    private List<UserEntity> usuarios;

    @OneToMany(mappedBy = "rol")
    private List<PermisoEntity> permisos;

}