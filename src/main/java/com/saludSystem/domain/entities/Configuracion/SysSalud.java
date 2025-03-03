package com.saludSystem.domain.entities.Configuracion;

import com.saludSystem.domain.entities.Generals.Sucursal;
import com.saludSystem.domain.entities.Catalogo.Plan;
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
public class SysSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "hospital_id", nullable = false, unique = true)
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

    @Lob
    @Column(name = "foto", columnDefinition = "MEDIUMBLOB")
    private byte[] foto;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<User> usuarios;

    @OneToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
    private Plan plan;

}