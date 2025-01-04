package com.azvtech.sppo_service.application.dto.mapper;

import com.azvtech.sppo_service.application.dto.request.ConsortiumRequest;
import com.azvtech.sppo_service.application.dto.response.ConsortiumResponse;
import com.azvtech.sppo_service.domain.model.Consortium;
import org.springframework.stereotype.Component;

/**
 * @author Fellipe Toledo
 */

@Component
public class ConsortiumMapper {

    public Consortium toEntity (ConsortiumRequest request) {
        Consortium consortium = new Consortium();
        consortium.setName(request.getName());
        consortium.setCnpj(request.getCnpj());
        return consortium;
    }

    public ConsortiumResponse toResponse (Consortium consortium) {
        return ConsortiumResponse.builder()
                .id(consortium.getId())
                .name(consortium.getName())
                .cnpj(consortium.getCnpj())
                .createdAt(consortium.getCreatedAt())
                .updatedAt(consortium.getUpdatedAt())
                .build();
    }
}
