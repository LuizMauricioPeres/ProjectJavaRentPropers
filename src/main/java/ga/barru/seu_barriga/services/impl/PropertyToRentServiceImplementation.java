package ga.barru.seu_barriga.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ga.barru.seu_barriga.model.PropertyToRent;
import ga.barru.seu_barriga.repository.PropertyToRentRepository;
import ga.barru.seu_barriga.services.PropertyToRentService;
import jakarta.transaction.Transactional;

@Service
public class PropertyToRentServiceImplementation  implements PropertyToRentService {

    private final PropertyToRentRepository propertyToRentRepository;

    public PropertyToRentServiceImplementation(PropertyToRentRepository propertyToRentRepository) {
        this.propertyToRentRepository = propertyToRentRepository;
    }

    public List<PropertyToRent> findAll() {
        return propertyToRentRepository.findAll();
    }

    public PropertyToRent findById(Long id) {
        return propertyToRentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public PropertyToRent create(PropertyToRent propertyToRent) {
        return propertyToRentRepository.save(propertyToRent);
    }

    @Transactional
    public PropertyToRent update(PropertyToRent propertyToRent) {
        return propertyToRentRepository.save(propertyToRent);
    }


    @Transactional
    @Override
    public void delete(Long id) {
        PropertyToRent property = findById(id);
        propertyToRentRepository.delete(property);
    }

}
