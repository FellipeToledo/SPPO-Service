package com.azvtech.sppo_service;

import com.azvtech.sppo_service.model.Consortium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Fellipe Toledo
 */

@Service
public class ConsortiumService {

    private final ConsortiumRepository consortiumRepository;

    public ConsortiumService(ConsortiumRepository consortiumRepository) {
        this.consortiumRepository = consortiumRepository;
    }

    public Consortium createConsortium(Consortium consortium) {
        return consortiumRepository.save(consortium);
    }

    public Iterable<Consortium> getAllConsortiums() {
        return consortiumRepository.findAll();
    }

    public void deleteConsortium(Long id) {
        Consortium existingConsortium = getConsortiumById(id);
        consortiumRepository.delete(existingConsortium);
    }

    private Consortium getConsortiumById(Long id) {
        return consortiumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consortium not found"));
    }
}
