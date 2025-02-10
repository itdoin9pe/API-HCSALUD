package com.saludSystem.entities.configuracion;

import com.saludSystem.entities.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipos_documentos")
public class TipoDocumento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoDocumento", nullable = false, unique = true)
    private Long id;

    @NotBlank(message = "El tipo de comprobante no puede estar vacío")
    @Column(name = "tipo_comprobante_id", nullable = false)
    private String tipoComprobanteId;

    @NotBlank(message = "La serie no puede estar vacía")
    @Column(name = "serie", nullable = false)
    private String serie;

    @NotNull(message = "El inicio no puede estar vacío")
    @Min(value = 0, message = "El inicio debe ser un número positivo")
    @Column(name = "inicio", nullable = false)
    private Integer inicio;

    @NotNull(message = "El fin no puede estar vacío")
    @Min(value = 0, message = "El fin debe ser un número positivo")
    @Column(name = "fin", nullable = false)
    private Integer fin;

    @NotNull(message = "El correlativo actual no puede estar vacío")
    @Min(value = 0, message = "El correlativo actual debe ser un número positivo")
    @Column(name = "correlativo_actual", nullable = false)
    private Integer correlativoActual;

    @NotNull(message = "El estado no puede estar vacío")
    @Column(name = "estado", nullable = false)
    private Integer estado;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creado_en", updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "actualizado_en")
    private Date updatedAt;

}