package com.azvtech.sppo_service.shared.exception.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fellipe Toledo
 */

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private LocalDateTime timestamp;
    private String message;
    private Integer statusCode;
    private String status;
    private String path;
    private List<ValidationError> errors;

    @Data
    @Builder
    public static class ValidationError {
        private String field;
        private String message;
    }
}
