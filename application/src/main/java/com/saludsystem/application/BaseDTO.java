package com.saludsystem.application;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class BaseDTO {
    private UUID hospitalId;
    private UUID userId;
}