package com.azvtech.sppo_service.exception;

/**
 * @author Fellipe Toledo
 */
public class DuplicatedCnpjException extends RuntimeException {
    public DuplicatedCnpjException(String cnpj) {
        super("CNPJ already exists: " + cnpj);
    }
}
