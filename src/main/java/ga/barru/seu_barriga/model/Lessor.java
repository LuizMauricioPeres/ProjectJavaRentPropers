package ga.barru.seu_barriga.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lessor extends People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount = BigDecimal.valueOf(0);

    @OneToMany
    private final List<PropertyToRent> properties = new ArrayList<PropertyToRent>();

    public Long getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<PropertyToRent> getProperties() {
        return properties;
    }

    public void setAmount(BigDecimal amount) {
        this.amount=amount;
    }

    public void addAmount(BigDecimal amount) {
        this.amount=this.amount.add(amount);
    }

    public List<PropertyToRent> removeProperties(List<PropertyToRent> properties) {
        this.properties.removeAll(properties);
        return properties;
    }

    public void setProperties(List<PropertyToRent> properties) {
        this.properties.addAll(properties);
    }
}
