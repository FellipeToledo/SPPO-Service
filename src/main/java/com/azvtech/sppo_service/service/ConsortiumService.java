package com.azvtech.sppo_service;

import com.azvtech.sppo_service.exception.ConsortiumNotFoundException;
import com.azvtech.sppo_service.exception.DuplicatedCnpjException;
import com.azvtech.sppo_service.model.Consortium;
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
        if (consortium.getId() == null && consortiumRepository.existsByCnpj(consortium.getCnpj())) {
            throw new DuplicatedCnpjException(consortium.getCnpj());
        }
        return consortiumRepository.save(consortium);
    }

    public Iterable<Consortium> getAllConsortiums() {
        return consortiumRepository.findAll();
    }

    public Consortium getConsortiumById(Long id) {
        return consortiumRepository.findById(id)
                .orElseThrow(() -> new ConsortiumNotFoundException(id));
    }

    public Consortium updateConsortium(Consortium consortium) {
        if (!consortiumRepository.existsById(consortium.getId())) {
            throw new ConsortiumNotFoundException(consortium.getId());
        }

        return consortiumRepository.save(consortium);
    }

    public void deleteConsortium(Long id) {
        if (!consortiumRepository.existsById(id)) {
            throw new ConsortiumNotFoundException(id);
        }

        consortiumRepository.deleteById(id);
    }
}
