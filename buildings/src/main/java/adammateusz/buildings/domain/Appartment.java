package adammateusz.buildings.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table//(uniqueConstraints = {@UniqueConstraint(columnNames = { "appartmentNumber", "appartment_address_id" } )})
@Entity
public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String appartmentNumber;
    @JsonIgnore
    @ManyToOne//(optional=false)
    private Building appartmentAddress;
    @OneToOne(cascade = CascadeType.ALL)
    private Owner tenant;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Bill> billList;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAppartmentNumber() {
        return appartmentNumber;
    }
    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }
    public Building getAppartmentAddress() {
        return appartmentAddress;
    }
    public void setAppartmentAddress(Building appartmentAddress) {
        this.appartmentAddress = appartmentAddress;
    }
    public Owner getTenant() { return tenant; }
    public void setTenant(Owner tenant) { this.tenant = tenant; }
    public List<Bill> getBillList() { return billList; }
    public void setBillList(List<Bill> billList) { this.billList = billList; }
}
