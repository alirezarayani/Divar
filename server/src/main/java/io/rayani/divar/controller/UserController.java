package io.rayani.divar.controller;

import io.rayani.divar.entity.Province;
import io.rayani.divar.entity.User;
import io.rayani.divar.exception.EmailIsExists;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.service.ProvinceService;
import io.rayani.divar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final ProvinceService provinceService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserController(UserService userService, ProvinceService provinceService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.provinceService = provinceService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/{name:.+}/")
    public User getUser(@PathVariable String name) throws NotfoundException {
        Optional<? extends User> userByEmail = userService.getUserByEmail(name);
        if (userByEmail.isEmpty()) {
            throw new NotfoundException("this email doesn't exists");
        }
        return userByEmail.get();
    }
    @PostMapping("/user")
    public User authentication(@RequestBody User user) throws NotfoundException {
        Optional<? extends User> userByEmail = userService.getUserByEmail(user.getEmail().trim());
        if (userByEmail.isPresent()) {
            String encodeGetPassword = passwordEncoder.encode(user.getPassword());
            if (encodeGetPassword.equals(user.getPassword())){
                return userByEmail.get();
            }
        }

        throw new NotfoundException("this email doesn't exists");
    }
    @PostMapping
    public User saveUser(@RequestBody User user)throws NotfoundException, EmailIsExists {

        Optional<Province> province = provinceService.getProvince(user.getId());
        Optional<? extends User> IsEmailExist = userService.getUserByEmail(user.getEmail().trim());
        if(IsEmailExist.isEmpty()){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userService.saveUser(user);
        }
        throw new EmailIsExists("There is an account with that email address:"+user.getEmail());
    }

//    @GetMapping("/{id}")
//    public User getUserByFirstName(@PathVariable String userName){
//        return   userService.getUserByFirstName(userName);
//    }
}
