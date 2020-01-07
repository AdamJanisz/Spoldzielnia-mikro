package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Bill;
import adammateusz.buildings.domain.BuildingOwnerException;
import adammateusz.buildings.service.AppartmentService;
import adammateusz.buildings.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("building/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private AppartmentService appartmentService;

    @GetMapping("/")
    public List<Bill> getBillsLists() { return billService.getAllBills(); }
    @GetMapping("/{id}")
    public Bill getBill(@PathVariable long id){
        return billService.getBill(id);
    }
    @GetMapping("/appartment/{id}")
    public List<Bill> getAppartmentBills(@PathVariable long id){ return billService.listAppartmentBills(id); }
    @PostMapping("/")
    public Bill createNewBill(@RequestBody Bill bill){
        return billService.addBill(bill);
    }
    @PutMapping("/")
    public void editBill(@RequestBody Bill bill){ billService.editBill(bill); }
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteBill (@RequestParam long id){
        billService.removeBill(id);
    }

    @Scheduled(cron="0 */5 * * * *")
    public void generateBills() {

            appartmentService.listAllAppartments().forEach(appartment -> {
            Date date = new Date();

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMM"); //month name
            String formattedDate = simpleDateformat.format(date);

            Bill bill = new Bill();
            bill.setAppartment(appartment);
            bill.setColdWater(0);
            bill.setHotWater(0);
            bill.setElectricity(0);
            bill.setMaintenanceFund(0);
            bill.setSewage(0);
            bill.setDate(formattedDate);
            bill.setTotalAmount();
            billService.addBill(bill);
        });
    }

}
