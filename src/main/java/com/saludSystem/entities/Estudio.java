package com.saludSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estudio", nullable = false, unique = true)
    private UUID estudioId;

    @NotBlank(message = "The description field can't be blank")
    @Column(nullable = false)
    private String descripcion;

}
