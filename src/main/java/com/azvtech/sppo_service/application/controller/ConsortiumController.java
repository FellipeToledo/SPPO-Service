package com.azvtech.sppo_service.application.controller;

import com.azvtech.sppo_service.application.dto.request.ConsortiumRequest;
import com.azvtech.sppo_service.application.dto.response.ConsortiumResponse;
import com.azvtech.sppo_service.application.dto.response.PageResponse;
import com.azvtech.sppo_service.domain.service.ConsortiumDomainService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("/api/v1/consortium")
@RequiredArgsConstructor
public class ConsortiumController {

    private final ConsortiumDomainService consortiumDomainService;


    @PostMapping
    public ResponseEntity<ConsortiumResponse> create(@Valid @RequestBody ConsortiumRequest request) {
       ConsortiumResponse response = consortiumDomainService.createConsortium(request);
       URI location = URI.create(String.format("api/v1/consortium/%s", response.getId()));
       return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<PageResponse<ConsortiumResponse>> getAll(
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(consortiumDomainService.getAllConsortiums(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsortiumResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(consortiumDomainService.getConsortiumById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<ConsortiumResponse> update(
            @Valid @RequestBody ConsortiumRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(consortiumDomainService.updateConsortium(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        consortiumDomainService.deleteConsortium(id);
    }
}
