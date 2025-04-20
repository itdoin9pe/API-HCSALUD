package com.saludSystem.application.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;

@Service
public class OperadorServiceImpl implements OperadorService {

    private final BackupService backupService;
    private final EntityManager entityManager;

    public OperadorServiceImpl(BackupService backupService, EntityManager entityManager) {
        this.backupService = backupService;
        this.entityManager = entityManager;
    }


    @Override
    public void realizarBackup() {
        backupService.realizarBackup();
    }

    @Override
    @Transactional
    public void repararTablas() {
        // Obtener todas las tablas y ejecutar REPAIR TABLE
        entityManager.createNativeQuery("SHOW TABLES").getResultList()
                .forEach(table -> {
                    String tableName = (String) table;
                    entityManager.createNativeQuery("REPAIR TABLE " + tableName).executeUpdate();
                    System.out.println("Tabla reparada: " + tableName);
                });
    }

    @Override
    @Transactional
    public void optimizarTablas() {
        // Obtener todas las tablas y ejecutar OPTIMIZE TABLE
        entityManager.createNativeQuery("SHOW TABLES").getResultList()
                .forEach(table -> {
                    String tableName = (String) table;
                    entityManager.createNativeQuery("OPTIMIZE TABLE " + tableName).executeUpdate();
                    System.out.println("Tabla optimizada: " + tableName);
                });
    }

}

