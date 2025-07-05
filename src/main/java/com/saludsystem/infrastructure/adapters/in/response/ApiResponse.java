package com.saludsystem.infrastructure.adapters.in.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

    private boolean success;

    @Getter
    private String message;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getIsSuccess() {
        return success;
    }

}