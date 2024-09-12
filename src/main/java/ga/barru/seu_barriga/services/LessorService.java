package ga.barru.seu_barriga.services;

import java.util.List;
import ga.barru.seu_barriga.model.Lessor;
import jakarta.transaction.Transactional;

public interface LessorService {

    public List<Lessor> findAll();
    public Lessor findById(Long id);
    @Transactional
    public Lessor create(Lessor lessor);
    @Transactional
    public Lessor update(Lessor lessor);
    @Transactional
    public void delete(Lessor lessor);

}
