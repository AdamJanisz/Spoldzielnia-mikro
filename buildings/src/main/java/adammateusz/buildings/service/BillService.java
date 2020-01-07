package adammateusz.buildings.service;

import adammateusz.buildings.domain.Bill;

import java.util.List;

public interface BillService {

    public List<Bill> getAllBills();
    public List<Bill> listApartmentBills(long apartmentId);
    public Bill addBill(Bill bill);
    public void editBill(Bill bills);
    public Bill getBill(long id);
    public void removeBill(long id);
    public void updateBill(int coldWater,long id);

}
