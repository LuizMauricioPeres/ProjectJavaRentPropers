package ga.barru.seu_barriga.controller;

import ga.barru.seu_barriga.model.Tenant;
import ga.barru.seu_barriga.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity<List<Tenant>> findAll() {
        List<Tenant> tenants = this.tenantService.findAll();
        if (tenants.equals(Collections.emptyList())){
            ResponseEntity.ok("{}");
        }
        return ResponseEntity.ok(tenants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tenant> findById(@PathVariable Long id){
        Tenant tenant = this.tenantService.findById(id);
        return ResponseEntity.ok(tenant);
    }

    @PostMapping("/")
    public ResponseEntity<Tenant> post(@RequestBody Tenant tenant) {

        Tenant tenantSave=null;
        if(tenant.getId().equals(0L)){
            tenantSave = this.tenantService.create(tenant);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(tenantSave.getId()).toUri();
            return  ResponseEntity.created(uri).body(tenantSave);
        }else{
            throw new IllegalArgumentException( "The ID is generated automatically.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tenant> put(@PathVariable Long id, @RequestBody Tenant tenant) {
        Tenant tenantSave=null;
        if (id.equals(0L)){
            throw new IllegalArgumentException( "The ID is required.");
        }
        if(tenant.getId().equals(0L)){
            tenant.setId(id);
        }
        tenantSave = this.tenantService.update(tenant);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(tenantSave.getId()).toUri();

        return  ResponseEntity.created(uri).body(tenantSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (id.equals(0L)){
            throw new IllegalArgumentException( "The ID is required.");
        }
        this.tenantService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
