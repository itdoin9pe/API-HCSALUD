package com.saludSystem.entities.catalogo;

import com.saludSystem.entities.BaseEntity;
import com.saludSystem.entities.User;
import com.saludSystem.entities.configuracion.SysSalud;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medidas")
public class Medida extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_medida", nullable = false, unique = true)
    private UUID medidaId;

    @Column(name = "nombres")
    private String nombre;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;

}