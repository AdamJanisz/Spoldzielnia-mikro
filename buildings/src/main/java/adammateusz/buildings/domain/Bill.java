package adammateusz.buildings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private boolean confirmed;
    private int electricity;
    private int hotWater;
    private int coldWater;
    private int sewage;
    private int maintenanceFund;
    private int totalAmount;
    private String date;
    @JsonIgnore
    @ManyToOne(optional = false)
    private Appartment appartment;



    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setId(long id) { this.id = id; }
    public long getId() {
        return id;
    }
    public int getElectricity() {
        return electricity;
    }
    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }
    public int getHotWater() {
        return hotWater;
    }
    public void setHotWater(int hotWater) {
        this.hotWater = hotWater;
    }
    public int getColdWater() {
        return coldWater;
    }
    public void setColdWater(int coldWater) {
        this.coldWater = coldWater;
    }
    public int getSewage() {
        return sewage;
    }
    public void setSewage(int sewage) {
        this.sewage = sewage;
    }
    public int getMaintenanceFund() {
        return maintenanceFund;
    }
    public void setMaintenanceFund(int maintenanceFund) {
        this.maintenanceFund = maintenanceFund;
    }
    public Appartment getAppartment() { return appartment; }
    public void setAppartment(Appartment appartment) { this.appartment = appartment; }
    public int getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount() {
        Building building = this.appartment.getAppartmentAddress();
        this.totalAmount = this.hotWater*building.getHotWaterPrice()
                +this.coldWater*building.getColdWaterPrice()
                +this.sewage*building.getSewagePrice()
                +this.electricity*building.getElectricityPrice()
                +this.maintenanceFund*building.getMaintenanceFundPrice();
    }

}
