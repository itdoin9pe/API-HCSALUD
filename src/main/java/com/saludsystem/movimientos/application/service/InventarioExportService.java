package com.saludsystem.movimientos.application.service;

import java.util.UUID;

public interface InventarioExportService {

    byte[] exportToExcel(UUID hospitalId);

    byte[] exportToPdf(UUID hospitalId);

}