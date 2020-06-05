package io.rayani.divar;

import com.google.common.collect.Lists;
import io.rayani.divar.entity.Province;
import io.rayani.divar.entity.User;
import io.rayani.divar.service.ProvinceService;
import io.rayani.divar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DivarApplication implements CommandLineRunner {
        private final UserService userService;
        private final ProvinceService provinceService;
    @Autowired
    public DivarApplication(UserService userService, ProvinceService provinceService) {
        this.userService = userService;
        this.provinceService = provinceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DivarApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
