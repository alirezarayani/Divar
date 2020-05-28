package io.rayani.divar.controller;

import io.rayani.divar.controller.Response.CategoryResponse;
import io.rayani.divar.controller.Response.ElectronicDeviceResponse;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.service.CategoryServiceImpl;
import io.rayani.divar.service.ElectronicDeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@CrossOrigin(origins = "http://localhost:4200",methods = RequestMethod.GET,maxAge = 36000)
public class CategoryController {
    private static final Logger LOGGER= LoggerFactory.getLogger(CategoryController.class);

    private final CategoryServiceImpl categoryServiceImpl;
    private final ElectronicDeviceService electronicDeviceService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryServiceImpl, ElectronicDeviceService electronicDeviceService) {
        this.categoryServiceImpl = categoryServiceImpl;
        this.electronicDeviceService = electronicDeviceService;
    }

    @GetMapping
    public List<CategoryResponse> getCategories(){
        LOGGER.info("Inside getCategories() ,return list of category");
        return categoryServiceImpl.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategory(@PathVariable Long id) throws NotfoundException {
        LOGGER.info("Inside getCategory() return category with id :"+id);
        return categoryServiceImpl.getCategoryById(id);
    }

    @GetMapping("/{id}/electronic-device")
    public List<ElectronicDeviceResponse> getElectronicDevice(@PathVariable Long id){
        LOGGER.info("Inside getElectronicDevice() from categoryController class and return List of ElectronicDevices with category id:"+id);
        return electronicDeviceService.getElectronicDeviceByFk(id);
    }
    @GetMapping("/{id}/electronic-devices/{idElectronic}")
    public ElectronicDeviceResponse getElectronicDevice(@PathVariable Long id,@PathVariable Long idElectronic) throws NotfoundException {
        LOGGER.info("Inside getElectronicDevice() from categoryController class that return electronicDevice with category id"+id );
        return electronicDeviceService.getElectronicDeviceByIdAndFk(idElectronic,id);
    }

}
