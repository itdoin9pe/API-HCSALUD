package com.saludSystem.application.services.Movimiento.impl;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.saludSystem.application.services.Movimiento.InventarioExportService;
import com.saludSystem.application.services.Movimiento.InventarioProjection;
import com.saludSystem.infrastructure.adapters.out.persistance.repository.Operaciones.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class InventarioExportServiceImpl implements InventarioExportService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    @Override
    public byte[] exportToExcel(UUID hospitalId) {
        List<InventarioProjection> inventarios = productoRepository
                .findInventarioDataByHospitalId(hospitalId, Pageable.unpaged()).getContent();

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Inventario");

            // Crear header
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Almacén", "Producto", "Marca", "Categoría", "Precio", "Unidad", "Stock"};
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Llenar datos
            int rowNum = 1;
            for (InventarioProjection inv : inventarios) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(inv.getNombreAlmacen());
                row.createCell(1).setCellValue(inv.getNombreProducto());
                row.createCell(2).setCellValue(inv.getNombreMarca());
                row.createCell(3).setCellValue(inv.getNombreCategoria());
                row.createCell(4).setCellValue(inv.getPrecioEntrada().doubleValue());
                row.createCell(5).setCellValue(inv.getUnidad());
                row.createCell(6).setCellValue(inv.getStock());
            }

            // Convertir a bytes
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error al generar Excel", e);
        }
    }

    @Override
    public byte[] exportToPdf(UUID hospitalId) {
        List<InventarioProjection> inventarios = productoRepository
                .findInventarioDataByHospitalId(hospitalId, Pageable.unpaged()).getContent();

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            // Título
            document.add(new Paragraph("Reporte de Inventario" + " ",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18)));

            // Tabla
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);

            // Headers
            Stream.of("Almacén", "Producto", "Marca", "Categoría", "Precio", "Unidad", "Stock")
                    .forEach(header -> {
                        PdfPCell cell = new PdfPCell();
                        cell.setBackgroundColor(new Color(200, 200, 200));
                        cell.setPhrase(new Phrase(header));
                        table.addCell(cell);
                    });

            // Datos
            for (InventarioProjection inv : inventarios) {
                table.addCell(inv.getNombreAlmacen());
                table.addCell(inv.getNombreProducto());
                table.addCell(inv.getNombreMarca());
                table.addCell(inv.getNombreCategoria());
                table.addCell(inv.getPrecioEntrada().toString());
                table.addCell(inv.getUnidad());
                table.addCell(String.valueOf(inv.getStock()));
            }

            document.add(table);
            document.close();
            return outputStream.toByteArray();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("Error al generar PDF", e);
        }
    }
}
