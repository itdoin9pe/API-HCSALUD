package com.saludSystem.entities.configuracion;

import com.saludSystem.entities.BaseEntity;
import com.saludSystem.entities.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sedes")
public class Sede extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_sede", nullable = false, unique = true)
    private UUID sedeId;

    @NotBlank
    @Column(name = "codigo", nullable = false)
    private String codigo;

    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ubigeo")
    private String ubigeo;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}