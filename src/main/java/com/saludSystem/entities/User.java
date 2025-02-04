package com.saludSystem.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

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

    @Builder
    public User(String username, String password, Role role, Doctor doctor) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.doctor = doctor;
    }
}
