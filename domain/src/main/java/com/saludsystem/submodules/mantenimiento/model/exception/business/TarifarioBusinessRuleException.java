package com.saludsystem.submodules.mantenimiento.model.exception.business;

import java.io.Serial;

public class TarifarioBusinessRuleException extends RuntimeException {
	
    @Serial
    private static final long serialVersionUID = 1L;
	
    public TarifarioBusinessRuleException(String message) {
        super(message);
    }
    
}