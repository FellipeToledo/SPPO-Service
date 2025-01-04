package com.azvtech.sppo_service.domain.service;

import com.azvtech.sppo_service.application.dto.request.ConsortiumRequest;
import com.azvtech.sppo_service.application.dto.response.ConsortiumResponse;
import com.azvtech.sppo_service.application.dto.response.PageResponse;
import com.azvtech.sppo_service.domain.model.Consortium;
import org.springframework.data.domain.Pageable;

/**
 * @author Fellipe Toledo
 */
public interface ConsortiumDomainService {

    public ConsortiumResponse createConsortium(ConsortiumRequest consortium);

    public PageResponse<ConsortiumResponse> getAllConsortiums(Pageable pageable);

    public ConsortiumResponse getConsortiumById(Long id);

    public ConsortiumResponse updateConsortium(Long id, ConsortiumRequest request);

    public void deleteConsortium(Long id);


}
