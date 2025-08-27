package com.saludsystem.submodules.security.validators;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
	
    @Serial
    private static final long serialVersionUID = 1L;
	
    public ResourceNotFoundException(String message){
        super(message);
    }
    
}