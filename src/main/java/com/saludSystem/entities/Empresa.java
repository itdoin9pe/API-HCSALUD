package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.SysSalud;
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
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_empresa", nullable = false, unique = true)
    private UUID empresaId;

    @NotBlank
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @ManyToOne
    @JoinColumn(name = "hospital_id", nullable = false)
    private SysSalud hospitalId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

}
