package com.saludsystem.domain.exception;

import com.saludsystem.infrastructure.adapters.in.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

//@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {
    //@ExceptionHandler(ResourceNotFoundException.class)
    /*
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, ex.getMessage()));
    }*/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) throws Exception {
        // Esta línea evita incluso que caigan aquí los errores de /actuator
        if (request.getRequestURI().startsWith("/actuator")) {
            throw ex; // ⚠️ Lanza la excepción original para que Spring Actuator maneje correctamente
        }

        return ResponseEntity
                .internalServerError()
                .body(Map.of(
                        "isSuccess", false,
                        "message", "Ocurrió un error inesperado: " + ex.getMessage()
                ));
    }
}
