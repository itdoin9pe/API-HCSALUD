package com.saludSystem.entities.configuracion;

import com.saludSystem.entities.Sucursal;
import com.saludSystem.entities.User;
import com.saludSystem.entities.catalogo.Plan;
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

    private String nombre;

    private String direccion;

    private String celular;

    private String email;

    private String ruc;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Lob
    @Column(name = "foto", columnDefinition = "MEDIUMBLOB")
    private byte[] foto;

    private Integer estado;

    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
    private List<Sucursal> sucursales = new ArrayList<>();

    @OneToMany(mappedBy = "hospital")
    private List<User> usuarios;

    @OneToOne
    @JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
    private Plan plan;

}