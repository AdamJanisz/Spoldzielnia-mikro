package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Apartment;
import adammateusz.buildings.domain.Bill;
import adammateusz.buildings.domain.Building;
import adammateusz.buildings.service.ApartmentService;
import adammateusz.buildings.service.BillService;
import adammateusz.buildings.service.BuildingService;
import adammateusz.buildings.service.EmailServiceClient;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    BuildingService buildingService;

    @RolesAllowed({"ROLE_ADMIN","ROLE_MANAGER"})
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
        System.out.println(billService.listApartmentBills(id).size());
        return billService.listApartmentBills(id); }
    @PostMapping("/")
    public Bill createNewBill(@RequestBody Bill bill){
        bill.setTotalAmount();
        return billService.addBill(bill);
    }

    @RolesAllowed({"ROLE_MANAGER"})
    @GetMapping("/managerName/{username}")
    public List<Bill> getBillsForManager(@PathVariable String username)
    {
        List<Building> managerBuilding=buildingService.listManagerBuildingsByUsername(username);
        List<Bill> managerBills=new ArrayList<>();
        for(Building b:managerBuilding)
        {
            for(Apartment a: b.getApartmentList())
            {
                for(Bill bill: a.getBillList())
                managerBills.add(bill);
            }

        }
        return managerBills;
    }


    @PutMapping("/")
    public void editBill(@RequestBody Bill bill){ billService.editBill(bill); }

    @RolesAllowed({"ROLE_MANAGER","ROLE_ADMIN"})
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
