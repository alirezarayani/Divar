package io.rayani.divar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:4200",methods = RequestMethod.GET,maxAge = 36000)
public class Test {
    @GetMapping
    public String  test(){
        return "Hello World";
    }
}
