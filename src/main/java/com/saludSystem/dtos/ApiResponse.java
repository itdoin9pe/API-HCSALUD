package com.saludSystem.dtos;

import lombok.Getter;

public class ApiResponse {
    private boolean isSuccess;
    @Getter
    private String message;

    public ApiResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

}
