package com.saludSystem.Catalogo.Alergia.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "alergias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlergiaModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID alergiaId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}