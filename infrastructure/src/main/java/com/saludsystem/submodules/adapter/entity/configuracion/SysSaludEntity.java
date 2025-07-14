package com.saludsystem.submodules.adapter.entity.configuracion;

import com.saludsystem.submodules.adapter.entity.catalogo.PlanEntity;
import com.saludsystem.submodules.adapter.entity.principal.SucursalEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital")
public class SysSaludEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "hospital_id", nullable = false)
    private UUID hospitalId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ruc", nullable = false)
    private String ruc;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "foto", nullable = true)
    private String foto;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<SucursalEntity> sucursales = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<UserEntity> usuarios;

    @OneToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
    private PlanEntity plan;

}