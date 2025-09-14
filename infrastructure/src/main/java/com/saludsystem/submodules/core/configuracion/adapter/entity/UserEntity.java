package com.saludsystem.submodules.core.configuracion.adapter.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude =
{ "rol", "hospital" })
@Entity
@Table(name = "users")
public class UserEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id_user", nullable = false, unique = true)
	private UUID userId;

	@NotBlank(message = "The last name field can't be blank")
	@Column(nullable = false)
	private String lastName;

	@NotBlank(message = "The first name field can't be blank")
	@Column(nullable = false)
	private String firstName;

	@NotBlank(message = "The phone number field can't be blank")
	@Column(nullable = false)
	private String phoneNumber;

	@NotBlank(message = "The address field can't be blank")
	@Column(nullable = false)
	private String address;

	@NotBlank(message = "The email field can't be blank")
	@Column(unique = true, nullable = false)
	private String email;

	@NotBlank(message = "The document type field can't be blank")
	@Column(nullable = false)
	private String documentType;

	@NotBlank(message = "The document number field can't be blank")
	@Column(unique = true, nullable = false)
	private String documentNumber;

	@Column(nullable = true)
	private String photo;

	@NotBlank(message = "The username field can't be blank")
	@Column(unique = true, nullable = false)
	private String username;

	@NotBlank(message = "The password field can't be blank")
	@Size(min = 8, message = "The password must have at least 5 characters")
	@Column(nullable = false, unique = true)
	private String password;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private RoleEntity rol;

	@ManyToOne
	@JoinColumn(name = "hospital_id", nullable = false)
	private SysSaludEntity hospital;
}