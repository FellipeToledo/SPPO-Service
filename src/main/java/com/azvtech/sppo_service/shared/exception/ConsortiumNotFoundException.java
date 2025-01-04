package com.azvtech.sppo_service.shared.exception;

/**
 * @author Fellipe Toledo
 */

public class ConsortiumNotFoundException extends RuntimeException{
    public ConsortiumNotFoundException(Long id) {
        super("Consortium not found with id: " + id);
    }
}
