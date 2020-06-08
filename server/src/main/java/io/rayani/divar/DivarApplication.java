package io.rayani.divar;

import io.rayani.divar.entity.Client;
import io.rayani.divar.reposiory.ClientRepository;
import io.rayani.divar.service.ProvinceService;
import io.rayani.divar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DivarApplication implements CommandLineRunner {
        private final UserService userService;
        private final ProvinceService provinceService;
        private final ClientRepository clientRepository ;
    @Autowired
    public DivarApplication(UserService userService, ProvinceService provinceService, ClientRepository clientRepository) {
        this.userService = userService;
        this.provinceService = provinceService;
        this.clientRepository = clientRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DivarApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        for(int i=0;i<30;i++){
            Client client = new Client();
            client.setNom("Errabi");
            client.setPrenom("Ayoub");
            client.setCIN("4YP5657");
            client.setAddress("Casablanca");
           // clientRepository.save(client);
        }
    }
}
