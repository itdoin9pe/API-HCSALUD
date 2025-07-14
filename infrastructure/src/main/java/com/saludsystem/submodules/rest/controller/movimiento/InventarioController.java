package com.saludsystem.submodules.rest.controller.movimiento;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Inventarios")
@RestController
@RequestMapping("/api/Inventarios")
public class InventarioController {

    /*
    private final InventarioService inventarioService;
    private final InventarioExportService inventarioExportService;

    public InventarioController(InventarioService inventarioService, InventarioExportService inventarioExportService) {
        this.inventarioService = inventarioService;
        this.inventarioExportService = inventarioExportService;
    }

    @PostMapping("/SaveInventario")
    public ApiResponse store(@Valid @RequestBody InventarioDTO inventarioDTO) {
        return inventarioService.saveInventario(inventarioDTO);
    }

    @GetMapping("/GetAllInventario")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = InventarioListResponse.class)))
    })
    public ListResponse<InventarioDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return inventarioService.getAllInventario(hospitalId, page, rows);
    }

    @GetMapping("/GetInventario/{inventarioId}")
    public CrearInventarioDTO getById(@PathVariable UUID inventarioId) {
        return inventarioService.getInventarioById(inventarioId);
    }

    @PutMapping("/UpdateInventario/{inventarioId}")
    public ApiResponse update(@PathVariable UUID inventarioId, @RequestBody ActualizarInventarioDTO actualizarInventarioDTO) {
        return inventarioService.updateInventario(inventarioId, actualizarInventarioDTO);
    }

    @DeleteMapping("/DeleteInventario/{inventarioId}")
    public ApiResponse destroy(@PathVariable UUID inventarioId) {
        return inventarioService.deleteInventario(inventarioId);
    }

    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500")
    })
    @GetMapping("/ExportExcel")
    public ResponseEntity<byte[]> exportExcel(
            @RequestParam UUID hospitalId,
            HttpServletResponse response) {

        byte[] excelBytes = inventarioExportService.exportToExcel(hospitalId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=inventario.xlsx")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(excelBytes);
    }

    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/pdf")),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500")
    })
    @GetMapping("/ExportPdf")
    public ResponseEntity<byte[]> exportPdf(
            @RequestParam UUID hospitalId,
            HttpServletResponse response) {

        byte[] pdfBytes = inventarioExportService.exportToPdf(hospitalId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=inventario.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }*/
}