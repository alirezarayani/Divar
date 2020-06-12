package io.rayani.divar.controller;

import io.rayani.divar.controller.Response.UserResponse;
import io.rayani.divar.entity.Role;
import io.rayani.divar.entity.User;
import io.rayani.divar.entity.UserRole;
import io.rayani.divar.exception.EmailIsExists;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.exception.PasswordNotMatchException;
import io.rayani.divar.service.ProvinceService;
import io.rayani.divar.service.RoleService;
import io.rayani.divar.service.UserService;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final ProvinceService provinceService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final ConvertDtoAndEntity convertDtoAndEntity;
    @Autowired
    public UserController(UserService userService, ProvinceService provinceService, PasswordEncoder passwordEncoder, RoleService roleService, ConvertDtoAndEntity convertDtoAndEntity) {
        this.userService = userService;
        this.provinceService = provinceService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.convertDtoAndEntity = convertDtoAndEntity;
    }
    //TODO change the url name and change parameteres to get UserEmailResponse model
    @GetMapping(value = "/{name:.+}/")
    public User getUser(@PathVariable String name) throws NotfoundException {
        User userByEmail = userService.getUserByEmail(name);
        return userByEmail;
    }
    @PostMapping("/signin")
    public void login(){

    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid  @RequestBody UserResponse userResponse) throws NotfoundException, EmailIsExists, PasswordNotMatchException {


        if(userService.existsByEmail(userResponse.getEmail())){
            throw new EmailIsExists("There is an account with that email address:"+userResponse.getEmail()) ;
        } if(!userResponse.getPassword().equals(userResponse.getConfirmPassword())){
            throw new PasswordNotMatchException("password Not Match");
        }

        //Conver UserResponse to User
        User user = (User)convertDtoAndEntity.convertEntityDto(userResponse, new User());


        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Set<String> strRoles = userResponse.getRole();
        Set<Role> roles =new HashSet<>();
        if(strRoles == null || strRoles.size() == 0){
            Role userRole=roleService.findByRoleName(UserRole.USER);
            roles.add(userRole);
        }else{
            strRoles.forEach(role->{
                switch (role.toUpperCase()){
                    case "admin":
                        Role adminRole = roleService.findByRoleName(UserRole.ADMIN);
                        roles.add(adminRole);
                    break;
                    case "user":
                        Role userRole = roleService.findByRoleName(UserRole.USER);
                        roles.add(userRole);
                        break;
                    case "manager":
                        Role managerRole = roleService.findByRoleName(UserRole.MANAGER);
                        roles.add(managerRole);
                        break;
                }//end switch
            });
        }//end else
        user.setRole(roles);
         userService.saveUser(user);
         return ResponseEntity.ok("User registered Successfully");
    }
}
