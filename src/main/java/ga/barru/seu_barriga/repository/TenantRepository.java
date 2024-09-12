package ga.barru.seu_barriga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ga.barru.seu_barriga.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}