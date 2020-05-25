package io.rayani.divar.controller;

import io.rayani.divar.controller.Response.ElectronicDeviceResponse;
import io.rayani.divar.entity.ElectronicDevice;
import io.rayani.divar.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/electronic-devices")
@CrossOrigin("http://localhost:4200")
public class ElectronicDeviceController {
    private final ElectronicDeviceService electronicDeviceService;
    @Autowired
    public ElectronicDeviceController(ElectronicDeviceService electronicDeviceService) {
        this.electronicDeviceService = electronicDeviceService;
    }

    @GetMapping
    public List<ElectronicDeviceResponse> electronicDevices(){
        return electronicDeviceService.getElectronicS();
    }
}
