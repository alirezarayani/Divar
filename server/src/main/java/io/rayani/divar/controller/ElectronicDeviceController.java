package io.rayani.divar.controller;

import io.rayani.divar.controller.Response.ElectronicDeviceResponse;
import io.rayani.divar.entity.ElectronicDevice;
import io.rayani.divar.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public Page<ElectronicDevice> electronicDevices(@RequestParam("page") int page , @RequestParam("size")int size){
        Pageable pageable= PageRequest.of(page,size);
        return electronicDeviceService.getElectronics(pageable);
    }
    @GetMapping("/{id}")
    public ElectronicDevice getElectronicDevice(@PathVariable  Long id){
        return electronicDeviceService.getElectronicDevice(id);
    }
}
