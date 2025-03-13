package com.saludSystem.Configuracion.SysSalud.dominio;

import com.saludSystem.Catalogo.Plan.dominio.PlanModel;
import com.saludSystem.Configuracion.Usuario.dominio.UserModel;
import com.saludSystem.Generals.adapter.Sucursal;
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
public class SysSaludModel {

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
    private List<Sucursal> sucursales = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<UserModel> usuarios;

    @OneToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
    private PlanModel plan;

}