package io.rayani.divar.controller;

import io.rayani.divar.entity.Province;
import io.rayani.divar.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provinces")
@CrossOrigin(origins = "http://localhost:4200",methods = RequestMethod.GET,maxAge = 36000)
public class ProvinceController {
    private final ProvinceService provinceService;
    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping
    private List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }
}
