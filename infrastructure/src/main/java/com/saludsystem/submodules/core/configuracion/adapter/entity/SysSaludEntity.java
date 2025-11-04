package com.saludsystem.submodules.core.configuracion.adapter.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.saludsystem.submodules.core.catalogo.adapter.entity.PlanEntity;
import com.saludsystem.submodules.core.principal.adapter.entity.SucursalEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital")
public class SysSaludEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "hospital_id", nullable = false)
	private UUID hospitalId;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "direccion", nullable = false)
	private String direccion;

	@Column(name = "celular", nullable = false)
	private String celular;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "ruc", nullable = false)
	private String ruc;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false)
	private Date fecha;

	@Column(name = "foto", nullable = true)
	private String foto;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL)
	private List<SucursalEntity> sucursales = new ArrayList<>();

	@OneToMany(mappedBy = "hospital")
	private List<UserEntity> usuarios;

	@OneToOne
	@JoinColumn(name = "plan_id", referencedColumnName = "id_plan")
	private PlanEntity plan;
}