package io.rayani.divar.controller;

import io.rayani.divar.controller.Response.UserResponse;
import io.rayani.divar.entity.User;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.awt.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{name:.+}/")
    public User getUser(@PathVariable String name) throws NotfoundException {
        return userService.getUserByEmail(name);
    }

    @GetMapping
    public String getUserById(){
        return   "hello";
    }


//    @GetMapping("/{id}")
//    public User getUserByFirstName(@PathVariable String userName){
//        return   userService.getUserByFirstName(userName);
//    }
}
