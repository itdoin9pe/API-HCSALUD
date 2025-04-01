package com.saludSystem.Operaciones.Presentacion.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "presentaciones")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PresentacionModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "presentacion_id", nullable = false)
    private UUID presentacionId;

    @Column(name = "nombre_presentacion", nullable = false)
    private String nombre;

    @Column(name = "estado_presentacion", nullable = false)
    private Integer estado;

}
