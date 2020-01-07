package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.domain.Bill;

import java.util.List;

public interface BillService {

    public List<Bill> getAllBills();
    public Bill addBill(Bill bill);
    public void editBill(Bill bills);
    public Bill getBill(long id);
    public void removeBill(long id);
    public Bill calculateTotalAmount(Bill bill);
    public void updateBill(int coldWater,long id);

}
