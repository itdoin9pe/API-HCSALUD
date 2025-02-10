package com.saludSystem.entities;

import com.saludSystem.entities.configuracion.SysSalud;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

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

    @Column(nullable = true) // La foto puede ser opcional
    private String photo;

    @NotBlank(message = "The username field can't be blank")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "The password field can't be blank")
    @Size(min = 5, message = "The password must have at least 5 characters")
    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY) // Relación opcional con Doctor
    @JoinColumn(name = "doctor_id", nullable = true) // nullable = true permite que sea opcional
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id", nullable = false)
    private SysSalud hospital;

    @Builder
    public User(String lastName, String firstName, String phoneNumber, String address, String email, String documentType, String documentNumber, String photo, String username, String password, Role role, Doctor doctor, SysSalud hospital) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.role = role;
        this.doctor = doctor;
        this.hospital = hospital;
    }
}
