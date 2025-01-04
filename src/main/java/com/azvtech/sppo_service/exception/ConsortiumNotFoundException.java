package com.azvtech.sppo_service.exception;

/**
 * @author Fellipe Toledo
 */

public class ConsortiumNotFoundException extends RuntimeException{
    public ConsortiumNotFoundException(Long id) {
        super("Consortium not found id: " + id);
    }
}
