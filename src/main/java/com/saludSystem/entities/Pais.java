package com.saludSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paises")
public class Pais extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais", nullable = false, unique = true)
    private Integer id;

    @NotBlank
    @Column(name = "iso", nullable = false)
    private String iso;

    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "gentilicio")
    private String gentilicio;

    @Column(name = "orden")
    private Integer orden;

}