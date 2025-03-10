package com.saludSystem.CatalagoModule;

import com.saludSystem.Catalogo.Especialidad.aplicacion.services.EspecialidadService;
import com.saludSystem.Generals.security.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

@SpringBootTest
public class EspecialidadTest {
    @Autowired
    private EspecialidadService especialidadService;

    @Test
    void testEspecialidadNotFound() {
        UUID idInvalido = UUID.randomUUID();
        assertThrows(ResourceNotFoundException.class, () -> {
            especialidadService.getEspecialidadById(idInvalido);
        });
    }
}
