package com.saludSystem.Catalogo.Consentimiento.dominio;

import com.saludSystem.Generals.adapter.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "consentimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsentimientoModel extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "consentimiento_id", nullable = false)
    private UUID consentimientoId;

    @Column(name = "nombre_consentimiento", nullable = false)
    private String nombre;

    @Column(name = "observacion_consentimiento", nullable = false)
    private String observacion;

    @Column(name = "estado_consentimiento", nullable = false)
    private Integer estado;

    @Column(name = "texto_consentimiento", nullable = false)
    private String texto;

}