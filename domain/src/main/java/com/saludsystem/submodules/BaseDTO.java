package com.saludsystem.submodules;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseDTO {
    private UUID hospitalId;
    private UUID userId;
}