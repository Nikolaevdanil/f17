package com.example.demo.cotroller;

import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import com.example.demo.service.Servicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class mycontroller {
    @Autowired
    private Servicee service;

    @GetMapping()
    public String index(Model model1,Model model2) {
        model1.addAttribute("worker", service.getAllWorker());
        model2.addAttribute("manufacture",service.getAllManufacture());
        return "home";
    }
    @PostMapping("/addManufacture")
    public String addManufacture(@RequestParam String name,
                                 @RequestParam String address){
        Manufacture manufacture = new Manufacture();
        manufacture.setName(name);
        manufacture.setAddress(address);
        service.addManufacture(manufacture);
        return "redirect:/people";
    }
    @PostMapping("/addWorker")
    public String addWorker(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String middleName,
                            String name){
        Worker worker=new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setMiddleName(middleName);
        worker.manufacture = service.getManufactureById(service.getManufactureId(name));
        service.addWorker(worker);
        return "redirect:/people";
    }
    @PostMapping("/id/{id}")
    public String delete1(@PathVariable("id") Long id) {
        service.deleteManufactureById(id);

        return "redirect:/people";
    }
    @PostMapping("/{id}")
    public String delete2(@PathVariable("id") Long id) {

        service.deleteWorkerById(id);
        return "redirect:/people";
    }
    @PostMapping("/show")
    public @ResponseBody String getManufactureWorker(@RequestParam Long id){
        return "name:" + service.getBanByManufacture(id).getName() + "<br/> address:" + service.getBanByManufacture(id).getAddress() + "<br/> id:" + service.getBanByManufacture(id).getId();
    }

    @PostMapping("/getManufactureByName")
    public @ResponseBody
    String getManufacturesByName(){
        return service.printManufactures(service.filterByName());

    }
    @PostMapping("/getManufactureByManId")
    public @ResponseBody
    String getManufacturesByManId(){
        return service.printManufactures(service.filterByManId());
    }
    @PostMapping("/getManufactureByAddress")
    public @ResponseBody
    String getManufacturesByAddress(){
        return service.printManufactures(service.filterByAddress());
    }
    @PostMapping("/getWorkerByWorId")
    public @ResponseBody
    String getWorkersByWorId(){
        return service.printWorkers(service.filterByWorId());
    }
    @PostMapping("/getWorkerByFirstName")
    public @ResponseBody
    String getWorkersByFirstName(){
        return service.printWorkers(service.filterByFirstName());
    }
    @PostMapping("/getWorkerByLastName")
    public @ResponseBody
    String getWorkersByLastName(){
        return service.printWorkers(service.filterByLastName());
    }
    @PostMapping("/getWorkerByMiddleName")
    public @ResponseBody
    String getWorkersByMiddleName(){
        return service.printWorkers(service.filterByMiddleName());
    }

}
