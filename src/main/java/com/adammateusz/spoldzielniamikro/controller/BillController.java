package com.adammateusz.spoldzielniamikro.controller;

import com.adammateusz.spoldzielniamikro.domain.Bill;
import com.adammateusz.spoldzielniamikro.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appUser/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @CrossOrigin
    @GetMapping("/")
    public List<Bill> getAppUsersLists() {
        return billService.getAllBills();
    }
    @PostMapping("/")
    public Bill createNewBill(@RequestBody Bill bill)

    {
//        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String currentUsername= ((UserDetails)principal).getUsername();
//        System.out.println("TUTUTUAUTAT");
//        System.out.println(currentUsername);
        return billService.addBill(bill);
    }
    @PutMapping("/")
    public void editAppUser(@RequestParam long id,@RequestBody Bill bill){
        System.out.println("proba edycji rachunku");
    }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteBill (@RequestParam long id){
       billService.removeBill(id);
    }

}
