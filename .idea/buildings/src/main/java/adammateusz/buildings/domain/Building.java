package adammateusz.buildings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Table(name="buildings")
@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull
    @Column(name="city",nullable=false)
    private String city;
    @NotNull
    private String street;
    @NotNull
    private String buildingNumber;
    private int electricityPrice;
    private int hotWaterPrice;
    private int coldWaterPrice;
    private int sewagePrice;
    private int maintenanceFundPrice;
    @JsonIgnore
    @ManyToOne
    private AppUser owner;
   /* @OneToMany(cascade = CascadeType.ALL,mappedBy = "appartmentAddress")
    private List<Appartment> appartmentList;*/

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getBuildingNumber() { return buildingNumber; }
    public void setBuildingNumber(String buildingNumber) { this.buildingNumber = buildingNumber; }
    public int getElectricityPrice() { return electricityPrice; }
    public void setElectricityPrice(int electricityPrice) { this.electricityPrice = electricityPrice; }
    public int getHotWaterPrice() { return hotWaterPrice; }
    public void setHotWaterPrice(int hotWaterPrice) { this.hotWaterPrice = hotWaterPrice; }
    public int getColdWaterPrice() { return coldWaterPrice; }
    public void setColdWaterPrice(int coldWaterPrice) { this.coldWaterPrice = coldWaterPrice; }
    public int getSewagePrice() { return sewagePrice; }
    public void setSewagePrice(int sewagePrice) { this.sewagePrice = sewagePrice; }
    public int getMaintenanceFundPrice() { return maintenanceFundPrice; }
    public void setMaintenanceFundPrice(int maintenanceFundPrice) { this.maintenanceFundPrice = maintenanceFundPrice; }
    public AppUser getOwner() { return owner; }
    public void setOwner(AppUser owner) { this.owner = owner; }
}
