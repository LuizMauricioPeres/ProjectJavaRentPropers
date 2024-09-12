package ga.barru.seu_barriga.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import ga.barru.seu_barriga.model.Tenant;
import ga.barru.seu_barriga.repository.TenantRepository;
import ga.barru.seu_barriga.services.TenantService;
import jakarta.transaction.Transactional;

@Service
public class TenantServiceImplementation implements TenantService{


    private final TenantRepository tenantRepository;

    public TenantServiceImplementation(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public List<Tenant> findAll(){
        return tenantRepository.findAll();
    }

    public Tenant findById(Long id){
        return tenantRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public Tenant create(Tenant tenant){

        if ( !tenant.getId().equals(0L) && tenantRepository.existsById(tenant.getId())  ){
            throw new IllegalArgumentException("This tenant already exists!");
        }
        return tenantRepository.save(tenant);
    }

    @Transactional
    public Tenant update(Tenant tenant){

        tenantExists(tenant.getId());
        return tenantRepository.save(tenant);
    }

    @Transactional
    public void delete(Long id){

        Tenant tenant = findById(id);
        tenantRepository.delete(tenant);
    }

    private void tenantExists(Long id){
        if ( id.equals(0L) ){
            throw new IllegalArgumentException("This tenant's id cannot be null");
        }else if ( tenantRepository.existsById(id)  ){
            throw new IllegalArgumentException("this tenant does not already exists");
        }
    }

}
