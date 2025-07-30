    package com.saludsystem.submodules.core.catalogo.rest.controller.command;

    import com.saludsystem.submodules.catalogo.command.create.CategoriaCreateHandler;
    import com.saludsystem.submodules.catalogo.command.delete.CategoriaDeleteHandler;
    import com.saludsystem.submodules.catalogo.command.edit.CategoriaEditHandler;
    import com.saludsystem.submodules.catalogo.model.constant.CategoriaConstant;
    import com.saludsystem.submodules.catalogo.model.dto.command.CategoriaCreateCommand;
    import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarCategoriaDTO;
    import com.saludsystem.submodules.response.ApiResponse;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;

    @Tag(name = "Categorias")
    @RestController
    @RequestMapping("/api/Categorias")
    public class CategoriaCommandController  {

        private final CategoriaCreateHandler createHandler;
        private final CategoriaEditHandler editHandler;
        private final CategoriaDeleteHandler deleteHandler;

        public CategoriaCommandController(CategoriaCreateHandler createHandler, CategoriaEditHandler editHandler, CategoriaDeleteHandler deleteHandler) {
            this.createHandler = createHandler;
            this.editHandler = editHandler;
            this.deleteHandler = deleteHandler;
        }

        @PostMapping("/Save")
        public ApiResponse save(@RequestBody CategoriaCreateCommand dto) {
            createHandler.execute(dto);
            return new ApiResponse(true, CategoriaConstant.CREATED);
        }

        @PutMapping("/Update/{id}")
        public ApiResponse update(@PathVariable UUID id, @RequestBody ActualizarCategoriaDTO dto) {
            editHandler.execute(id, dto);
            return new ApiResponse(true, CategoriaConstant.UPDATED);
        }

        @DeleteMapping("/Delete/{id}")
        public ApiResponse delete(@PathVariable UUID id) {
            deleteHandler.execute(id);
            return new ApiResponse(true, CategoriaConstant.DELETED);
        }
    }