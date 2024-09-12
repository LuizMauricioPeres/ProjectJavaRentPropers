package ga.barru.seu_barriga.services;

import java.util.List;
import ga.barru.seu_barriga.model.Tenant;
import jakarta.transaction.Transactional;

public interface TenantService {

    public List<Tenant> findAll();

    public Tenant findById(Long id);

    @Transactional
    public Tenant create(Tenant tenant);

    @Transactional
    public Tenant update(Tenant tenant);

    @Transactional
    public void delete(Long id);


}
