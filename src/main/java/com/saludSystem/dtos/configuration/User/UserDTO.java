package com.saludSystem.dtos.configuration.User;

import com.saludSystem.enums.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDTO {
    private UUID userId;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String address;
    private String email;
    private String documentType;
    private String documentNumber;
    private String photo;
    public String username;
    public String password;
    private UserRole role;
    private UUID doctorId;
    private UUID hospitalId;
}
