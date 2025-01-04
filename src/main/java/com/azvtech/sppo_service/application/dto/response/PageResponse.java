package com.azvtech.sppo_service.application.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Data
@Builder
public class PageResponse<T> {

    private List<T> content;
    private PaginationInfo pagination;

    @Data
    @Builder
    public static class PaginationInfo {
        private int pageNumber;
        private int pageSize;
        private long totalElements;
        private int totalPages;
    }
}
