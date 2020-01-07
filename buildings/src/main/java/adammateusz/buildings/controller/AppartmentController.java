package adammateusz.buildings.controller;

import adammateusz.buildings.domain.Appartment;
import adammateusz.buildings.domain.Bill;
import adammateusz.buildings.service.AppartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("building/appartment")
public class AppartmentController {
    @Autowired
    AppartmentService appartmentService;

    @GetMapping("/")
    public List<Appartment> getAppartmentLists() { return appartmentService.listAllAppartments(); }
    @GetMapping("/{id}")
    public Appartment getAppartment(@PathVariable long id){
        return appartmentService.getAppartment(id);
    }
    @GetMapping("/building/{id}")
    public List<Appartment> getAppartmentBills(@PathVariable long id){ return appartmentService.listBuildingAppartments(id); }
    @PostMapping("/build/{id}")
    public Appartment createNewAppartment(@RequestBody Appartment appartment,@PathVariable long id){return appartmentService.addAppartment(appartment,id);
    }
    @PutMapping("/")
    public void editAppartment(@RequestBody Appartment appartment){ appartmentService.editAppartment(appartment);}
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteAppartment(@RequestParam long id){
        appartmentService.removeAppartment(id);
    }

}
