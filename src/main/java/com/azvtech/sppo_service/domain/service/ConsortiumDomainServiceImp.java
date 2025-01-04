package com.azvtech.sppo_service.domain.service;

import com.azvtech.sppo_service.application.dto.mapper.ConsortiumMapper;
import com.azvtech.sppo_service.application.dto.request.ConsortiumRequest;
import com.azvtech.sppo_service.application.dto.response.ConsortiumResponse;
import com.azvtech.sppo_service.application.dto.response.PageResponse;
import com.azvtech.sppo_service.shared.exception.ConsortiumNotFoundException;
import com.azvtech.sppo_service.shared.exception.DuplicatedCnpjException;
import com.azvtech.sppo_service.domain.model.Consortium;
import com.azvtech.sppo_service.infrastructure.repository.ConsortiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Fellipe Toledo
 */

@Service
@RequiredArgsConstructor
public class ConsortiumDomainServiceImp implements ConsortiumDomainService{

    private final ConsortiumRepository consortiumRepository;
    private final ConsortiumMapper consortiumMapper;

    @Transactional
    public ConsortiumResponse createConsortium(ConsortiumRequest request) {
        if (consortiumRepository.existsByCnpj(request.getCnpj())) {
            throw new DuplicatedCnpjException(request.getCnpj());
        }

        Consortium consortium = consortiumMapper.toEntity(request);
        Consortium savedConsortium = consortiumRepository.save(consortium);
        return consortiumMapper.toResponse(savedConsortium);
    }

    @Transactional(readOnly = true)
    public PageResponse<ConsortiumResponse> getAllConsortiums(Pageable pageable) {
        Page<Consortium> page = consortiumRepository.findAll(pageable);

        return PageResponse.<ConsortiumResponse>builder()
                .content(page.getContent().stream()
                        .map(consortiumMapper::toResponse)
                        .toList())
                .pagination(PageResponse.PaginationInfo.builder()
                        .pageNumber(page.getNumber())
                        .pageSize(page.getSize())
                        .totalElements(page.getTotalElements())
                        .totalPages(page.getTotalPages())
                        .build())
                .build();
    }

    @Transactional(readOnly = true)
    public ConsortiumResponse getConsortiumById(Long id) {
        return consortiumMapper.toResponse(
                consortiumRepository.findById(id)
                        .orElseThrow(() ->new ConsortiumNotFoundException(id))
                );
    }

    @Transactional
    public ConsortiumResponse updateConsortium(Long id, ConsortiumRequest request) {
        Consortium consortium = consortiumRepository.findById(id)
                .orElseThrow(() -> new ConsortiumNotFoundException(id));

        // Verifica se o novo CNPJ já existe para outro consórcio
        consortiumRepository.findByCnpj(request.getCnpj())
                .filter(c -> !c.getId().equals(id))
                .ifPresent(c -> {
                    throw new DuplicatedCnpjException(request.getCnpj());
                });
        consortium.setName(request.getName());
        consortium.setCnpj(request.getCnpj());

        return consortiumMapper.toResponse(consortiumRepository.save(consortium));
    }

    @Transactional
    public void deleteConsortium(Long id) {
        if (!consortiumRepository.existsById(id)) {
            throw new ConsortiumNotFoundException(id);
        }
        consortiumRepository.deleteById(id);
    }
}
