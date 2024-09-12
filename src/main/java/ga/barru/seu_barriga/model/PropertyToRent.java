package ga.barru.seu_barriga.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class PropertyToRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private int rooms=0;

    private String features = "";
    private String adress;
    private StringBuilder sb;
    private BigDecimal rentValue;

    public PropertyToRent() {
    }

    public PropertyToRent(String adress, String features, BigDecimal rentValue) {
        this.setAdress(adress);
        this.setFeatures(features);
        this.setRentValue(rentValue);
    }

    public PropertyToRent(int rooms, String features, String adress, BigDecimal rentValue) {
        this.setRooms(rooms);
        this.setFeatures(features);
        this.setAdress(adress);
        this.setRentValue(rentValue);;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.sb.setLength(0);
        sb.append(features);
        this.features = sb.toString();
    }

    public BigDecimal getRentValue() {
        return rentValue;
    }

    public void setRentValue(BigDecimal rentValue) {
        this.rentValue = rentValue;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

}
