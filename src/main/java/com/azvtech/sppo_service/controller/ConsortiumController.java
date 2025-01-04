package com.azvtech.sppo_service;

import com.azvtech.sppo_service.model.Consortium;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("/api/v1/consortium")

public class ConsortiumController {

    private final ConsortiumService consortiumService;

    public ConsortiumController(ConsortiumService consortiumService) {
        this.consortiumService = consortiumService;
    }

    @PostMapping
    public ResponseEntity<Consortium> create(@Valid @RequestBody Consortium consortium) {
        return ResponseEntity.ok(consortiumService.createConsortium(consortium));
    }

    @GetMapping
    public ResponseEntity<Iterable<Consortium>> getAll() {
        return ResponseEntity.ok(consortiumService.getAllConsortiums());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consortium> getById(@PathVariable Long id) {
        return ResponseEntity.ok(consortiumService.getConsortiumById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Consortium> update(@Valid @RequestBody Consortium consortium, @PathVariable Long id) {
        consortium.setId(id);
        return ResponseEntity.ok(consortiumService.updateConsortium(consortium));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        consortiumService.deleteConsortium(id);
        return ResponseEntity.noContent().build();
    }
}
