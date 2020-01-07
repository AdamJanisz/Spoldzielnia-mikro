package com.adammateusz.spoldzielniamikro.service;

import com.adammateusz.spoldzielniamikro.dao.BillRepository;
import com.adammateusz.spoldzielniamikro.domain.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepository billRepository;

    @Transactional
    public List<Bill> listBills() {
        return billRepository.findAll();
    }


    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill addBill(Bill bill) {
    return billRepository.save(bill);
    }

    @Override
    public void editBill(Bill bill) {
        Bill oldBill=billRepository.findById(bill.getId());
        oldBill.setColdWater(bill.getColdWater());
        oldBill.setElectricity(bill.getElectricity());
        oldBill.setHotWater(bill.getHotWater());
        oldBill.setSewage(bill.getSewage());
        oldBill.setMaintenanceFund(bill.getMaintenanceFund());
        billRepository.save(oldBill);

    }

    @Override
    public Bill getBill(long id) {
        return billRepository.findById(id);
    }

    @Override
    public void removeBill(long id) {
        billRepository.delete(billRepository.findById(id));
    }

    @Override
    public Bill calculateTotalAmount(Bill bill) {

       return null;
    }

    @Override
    public void updateBill(int coldWater, long id) {

    }
}

