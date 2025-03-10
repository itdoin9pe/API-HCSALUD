package com.saludSystem.Catalogo.TipoCitado.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipo_citado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoCitadoModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "tipoCitadoId", nullable = false)
    private UUID tipoCitadoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "estado", nullable = false)
    private Integer estado;

}
