package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.AppUser;
import com.adammateusz.spoldzielniamikro.domain.Bill;
import com.adammateusz.spoldzielniamikro.service.AppUserService;
import com.adammateusz.spoldzielniamikro.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

@RestController
@RequestMapping("appUser/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/")
    public List<Bill> getBillsLists() { return billService.getAllBills(); }
    @GetMapping("/{id}")
    public Bill getBill(@PathVariable long id){
        return billService.getBill(id);
    }
    @PutMapping("/")
    public void editBill(@RequestBody Bill bill){ billService.editBill(bill); }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteBill (@RequestParam long id){
       billService.removeBill(id);
    }


    @Scheduled(cron="0 */5 * * * *")
    public void generateBills() {

        appUserService.listAppUser().forEach(appUser -> {
            Date date = new Date();

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMM"); //month name
            String formattedDate = simpleDateformat.format(date);

            Bill bill = new Bill();
            bill.setAppUser(appUser);
            bill.setColdWater(0);
            bill.setHotWater(0);
            bill.setElectricity(0);
            bill.setMaintenanceFund(0);
            bill.setSewage(0);
            bill.setDate(formattedDate);
            billService.addBill(bill);
        });
    }

}
