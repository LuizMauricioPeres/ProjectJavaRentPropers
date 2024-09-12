package ga.barru.seu_barriga.services;

import java.util.List;
import ga.barru.seu_barriga.model.PropertyToRent;
import jakarta.transaction.Transactional;

public interface PropertyToRentService {
    public List<PropertyToRent> findAll();
    public PropertyToRent findById(Long id);
    @Transactional
    public PropertyToRent create(PropertyToRent propertyToRent);
    @Transactional
    public PropertyToRent update(PropertyToRent propertyToRent);
    @Transactional
    public void delete(Long id);

}
