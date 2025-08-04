package com.saludsystem.submodules.configuracion.model.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class PermisoDTO  {
    private UUID permisoId;
    private UUID menuId;
    private UUID rolId;
    private Boolean read;
    private Boolean insert;
    private Boolean update;
    private Boolean delete;

    public PermisoDTO(UUID id, Boolean insert, Boolean read, Boolean update, Boolean delete,
                      UUID rolId, UUID menuId) {
        this.setRolId(id);
        this.setInsert(insert);
        this.setRead(read);
        this.setUpdate(update);
        this.setDelete(delete);
        this.setRolId(rolId);
        this.setMenuId(menuId);
    }

}