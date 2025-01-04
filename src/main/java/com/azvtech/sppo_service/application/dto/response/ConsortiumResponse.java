package com.azvtech.sppo_service.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */

@Data
@Builder
public class ConsortiumResponse {

    private Long id;
    private String name;
    private String cnpj;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
