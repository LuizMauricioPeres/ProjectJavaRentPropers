package ga.barru.seu_barriga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ga.barru.seu_barriga.model.PropertyToRent;

public interface PropertyToRentRepository extends JpaRepository<PropertyToRent, Long> {
}