package com.saludsystem.submodules.movimiento.port.in.service;

import java.util.UUID;

public interface InventarioExportService {

    byte[] exportToExcel(UUID hospitalId);

    byte[] exportToPdf(UUID hospitalId);

}