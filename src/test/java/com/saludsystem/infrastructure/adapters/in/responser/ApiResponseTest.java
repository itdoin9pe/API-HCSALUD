package com.saludsystem.infrastructure.adapters.in.responser;

import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {
    @Test
    void shouldCreateApiResponseWithCorrectValues() {
        // Given
        boolean success = true;
        String message = "Operación exitosa";

        // When
        ApiResponse response = new ApiResponse(success, message);

        // Then
        assertTrue(response.isSuccess());
        assertEquals("Operación exitosa", response.getMessage());
    }

    @Test
    void shouldSetAndGetValues() {
        // Given
        ApiResponse response = new ApiResponse(false, "Mensaje inicial");

        // When
        response.setSuccess(true);
        response.setMessage("Mensaje modificado");

        // Then
        assertTrue(response.isSuccess());
        assertEquals("Mensaje modificado", response.getMessage());
    }
}