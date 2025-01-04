package com.azvtech.sppo_service.shared.exception;

/**
 * @author Fellipe Toledo
 */
public class DuplicatedCnpjException extends RuntimeException {
    public DuplicatedCnpjException(String cnpj) {
        super("CNPJ " + cnpj + " already exists" );
    }
}
