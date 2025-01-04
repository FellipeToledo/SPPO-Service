package com.azvtech.sppo_service.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * @author Fellipe Toledo
 */

@Data
public class ConsortiumRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @CNPJ(message = "Invalid CNPJ")
    @NotBlank(message = "CNPJ is required")
    private String cnpj;
}
