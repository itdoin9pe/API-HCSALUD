package com.saludSystem.domain.model.Configuracion;

import com.saludSystem.domain.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rol_id", nullable = false, unique = true)
    private UUID roleId;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "rol")
    private List<UserEntity> usuarios;

    @OneToMany(mappedBy = "rol")
    private List<PermisoEntity> permisos;

}