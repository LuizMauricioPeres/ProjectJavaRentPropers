package ga.barru.seu_barriga.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity()
public class Tenant extends People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    public void setId(Long id) {
        this.id=id;
    }

    public Long getId() {
        return id;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void addAmount(BigDecimal amount) {
        this.amount=this.amount.add(amount);
    }

    public PropertyToRent getRentedHouse() {
        return rentedHouse;
    }

    public void setRentedHouse(PropertyToRent rentedHouse) {
        this.rentedHouse = rentedHouse;
    }

    @OneToOne
    private PropertyToRent rentedHouse;

}
