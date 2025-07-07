package com.saludsystem.paciente.domain.model;

import com.saludsystem.shared.domain.model.BaseEntity;
import com.saludsystem.catalogo.domain.model.ConsentimientoEntity;
import com.saludsystem.medico.domain.model.DoctorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "pacientes_consentimientos")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PConsentimientoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "paciente_consentimiento_id", nullable = false)
    private UUID pacienteConsentimientoId;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity pacienteEntity;

    @ManyToOne
    @JoinColumn(name = "consentimiento_id", nullable = false)
    private ConsentimientoEntity consentimientoEntity;

    @Column(name = "cuerpo_consentimiento", columnDefinition = "TEXT")
    private String cuerpo;

    @Column(name = "fecha_consentimiento", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_consentimiento", nullable = false)
    private LocalTime hora;

    @Column(name = "apoderado_nombre")
    private String apoderadoNombre;

    @Column(name = "apoderado_documento")
    private String apoderadoDocumento;

    @Column(name = "apoderado_direccion")
    private String apoderadoDireccion;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private DoctorEntity doctorEntity;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Lob
    @Column(name = "firma")
    private byte[] firma;

}