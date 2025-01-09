package com.saludSystem.dtos;

public class ApiResponse {
    private boolean isSuccess;
    private String message;

    public ApiResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
