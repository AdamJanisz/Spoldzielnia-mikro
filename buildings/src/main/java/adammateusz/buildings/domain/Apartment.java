package adammateusz.buildings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table//(uniqueConstraints = {@UniqueConstraint(columnNames = { "apartmentNumber", "apartment_address_id" } )})
@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String apartmentNumber;
    @ManyToOne//(optional=false)
    private Building apartmentAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private Owner tenant;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Bill> billList;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getApartmentNumber() {
        return apartmentNumber;
    }
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }
    public Building getApartmentAddress() {
        return apartmentAddress;
    }
    public void setApartmentAddress(Building apartmentAddress) {
        this.apartmentAddress = apartmentAddress;
    }
    public Owner getTenant() { return tenant; }
    public void setTenant(Owner tenant) { this.tenant = tenant; }
    public List<Bill> getBillList() { return billList; }
    public void setBillList(List<Bill> billList) { this.billList = billList; }
}
