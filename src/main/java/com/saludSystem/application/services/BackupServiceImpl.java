package com.saludSystem.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment; // Import corregido
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class BackupServiceImpl implements BackupService {
    private final Environment env; // Ahora es el Environment de Spring

    @Override
    public void realizarBackup() {
        try {
            // Nota: Cambié "spring.datasource.name" por "spring.datasource.url"
            // ya que "name" no es una propiedad estándar de Spring
            String dbUrl = env.getProperty("DB_URL");
            // Extraemos el nombre de la BD de la URL
            String dbName = dbUrl.substring(dbUrl.lastIndexOf("/") + 1);
            String dbUser = env.getProperty("DB_USERNAME");
            String dbPass = env.getProperty("DB_PASSWORD");

            String backupPath = "backups/backup_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".sql";

            String executeCmd = "mysqldump -u" + dbUser + " -p" + dbPass + " " + dbName + " -r " + backupPath;

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("Backup realizado correctamente en: " + backupPath);
            } else {
                System.out.println("Error al realizar el backup");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}