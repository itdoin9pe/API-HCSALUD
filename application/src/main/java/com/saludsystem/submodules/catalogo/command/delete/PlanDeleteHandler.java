package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanDeleteHandler {
    private final PlanDao planDao;

    public PlanDeleteHandler(PlanDao planDao) {
        this.planDao = planDao;
    }

    public void execute(UUID uuid) {
        planDao.delete(uuid);
    }
}
