package com.saludSystem.dtos;

import com.saludSystem.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewUserDto {
    public String username;
    public String password;
    private UserRole role;
    private UUID doctorId;
    //private int roleId;
}
