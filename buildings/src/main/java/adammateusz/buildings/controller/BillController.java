package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Bill;
import adammateusz.buildings.service.ApartmentService;
import adammateusz.buildings.service.BillService;
import adammateusz.buildings.service.EmailServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("building/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private EmailServiceClient emailServiceClient;

    @GetMapping("/")
    public List<Bill> getBillsLists() {


        return billService.getAllBills(); }
    @GetMapping("/{id}")
    public Bill getBill(@PathVariable long id){
        return billService.getBill(id);
    }
    @GetMapping("/appartment/{id}")
    public List<Bill> getApartmentBills(@PathVariable long id){
        System.out.println("aparment id"+id);
        return billService.listApartmentBills(id); }
    @PostMapping("/")
    public Bill createNewBill(@RequestBody Bill bill){
        bill.setTotalAmount();
        return billService.addBill(bill);
    }
    @PutMapping("/")
    public void editBill(@RequestBody Bill bill){ billService.editBill(bill); }
    @GetMapping("/confirmation{bill}")
    public Bill acceptBill(@PathVariable String bill){
        System.out.println(bill);
        emailServiceClient.sendEmail("clothesshoparmani@gmail.com");
    return billService.acceptBill(Long.valueOf(bill)); }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteBill (@RequestParam long id){
        billService.removeBill(id);
    }

    @Scheduled(cron="0 */5 * * * *")
    public void generateBills() {

            apartmentService.listAllApartments().forEach(apartment -> {
            Date date = new Date();

            SimpleDateFormat simpleDateformat = new SimpleDateFormat("MMMM"); //month name
            String formattedDate = simpleDateformat.format(date);

            Bill bill = new Bill();
            bill.setApartment(apartment);
            bill.setColdWater(0);
            bill.setHotWater(0);
            bill.setElectricity(0);
            bill.setMaintenanceFund(0);
            bill.setSewage(0);
            bill.setDate(formattedDate);
            bill.setTotalAmount();
            billService.addBill(bill);
            apartment.getBillList().add(bill);
            apartmentService.editApartment(apartment);
        });
    }

}
