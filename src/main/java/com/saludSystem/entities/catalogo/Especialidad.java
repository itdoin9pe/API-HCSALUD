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
@Table(name = "especialidades")
public class Especialidad extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_especialidad", nullable = false, unique = true)
    private UUID especialidadId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotNull
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @NotNull
    @Column(name = "estado", nullable = false)
    private Integer estado;

}