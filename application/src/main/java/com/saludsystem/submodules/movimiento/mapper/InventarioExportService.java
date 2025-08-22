package com.saludsystem.submodules.movimiento.mapper;

import java.util.UUID;

public interface InventarioExportService {

    byte[] exportToExcel(UUID hospitalId);

    byte[] exportToPdf(UUID hospitalId);

}
