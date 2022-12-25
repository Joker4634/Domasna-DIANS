package com.example.pharmacies.web;

import com.example.pharmacies.model.Pharmacy;
import com.example.pharmacies.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class MainController {
    private final PharmacyService pharmacyService;

    public MainController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public String getMainPage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterPage(){ return "register"; }

    @GetMapping("/add")
    public String getAddPharmacy(){ return "addpharmacy"; }

    @GetMapping("/search")
    public String getSearchPharmacy(Model model){
        model.addAttribute("list", pharmacyService.listAllPharmacies());
        return "search";
    }
    @GetMapping("/demoUserRegister")
    public String demoUserRegister(Model model)
    {
        return "demoUserRegister";
    }
    @GetMapping("/demoUserLogin")
    public String demoUserLogin(Model model)
    {
        return "demoUserLogin";
    }
    @PostMapping("/search")
    public String postSearchPharmacy(Model model, @RequestParam String city)
    {
        if(city==null)
            model.addAttribute("list",pharmacyService.listAllPharmacies());
        else
        model.addAttribute("list",pharmacyService.findByContains(city));
        return "search";
    }
}
