package ga.barru.seu_barriga.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ga.barru.seu_barriga.model.Lessor;
import ga.barru.seu_barriga.repository.LessorRepository;
import ga.barru.seu_barriga.services.LessorService;
import jakarta.transaction.Transactional;

@Service
public class LessorServiceImplementation implements LessorService{
    private final LessorRepository lessorRepository;

    public LessorServiceImplementation(LessorRepository lessorRepository) {
        this.lessorRepository = lessorRepository;
    }

    public List<Lessor> findAll() {
        return lessorRepository.findAll();
    }

    public Lessor findById(Long id) {
        return lessorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Lessor create(Lessor lessor) {
        return lessorRepository.save(lessor);
    }

    @Transactional
    public Lessor update(Lessor lessor) {
        return lessorRepository.save(lessor);
    }

    @Transactional
    public void delete(Lessor lessor) {
        lessorRepository.delete(lessor);
    }
}
