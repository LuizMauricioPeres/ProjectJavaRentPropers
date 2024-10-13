package ga.barru.seu_barriga.controller;

import ga.barru.seu_barriga.model.PropertyToRent;
import ga.barru.seu_barriga.services.PropertyToRentService;
import ga.barru.seu_barriga.services.impl.PropertyToRentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/property2rent")
public class PropertyToRentController {
    private final PropertyToRentService propertyToRentService;

    @Autowired
    public PropertyToRentController(PropertyToRentService propertyToRentService) {
        this.propertyToRentService = propertyToRentService;
    }

    @GetMapping("")
    public ResponseEntity<List<PropertyToRent>> findAll() {
        List<PropertyToRent> propertyToRents = this.propertyToRentService.findAll();
        return ResponseEntity.ok(propertyToRents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyToRent> findById(@PathVariable Long id){
        PropertyToRent propertyToRent = propertyToRentService.findById(id);
        return ResponseEntity.ok(propertyToRent);
    }

    @PostMapping("/include")
    public ResponseEntity<PropertyToRent> post(@RequestBody PropertyToRent propertyToRent) {

        PropertyToRent propertyToRentSave;
        if(propertyToRent.getId().equals(0L)){
            propertyToRentSave = this.propertyToRentService.create(propertyToRent);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(propertyToRentSave.getId()).toUri();
            return  ResponseEntity.created(uri).body(propertyToRentSave);
        }else{
            throw new IllegalArgumentException( "The ID is generated automatically.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropertyToRent> put(@PathVariable Long id, @RequestBody PropertyToRent tenant) {
        PropertyToRent tenantSave=null;
        if (id.equals(0L)){
            throw new IllegalArgumentException( "The ID is required.");
        }
        if(tenant.getId().equals(0L)){
            tenant.setId(id);
        }
        tenantSave = this.propertyToRentService.update(tenant);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(tenantSave.getId()).toUri();

        return  ResponseEntity.created(uri).body(tenantSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (id.equals(0L)){
            throw new IllegalArgumentException( "The ID is required.");
        }
        this.propertyToRentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
