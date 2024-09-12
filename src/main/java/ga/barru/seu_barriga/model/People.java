package ga.barru.seu_barriga.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public People() {
    }
    public People(String name, String phone) {
        this.setName(name);
        this.setPhone(phone);
    }

    private String name;
    private String phone;


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
