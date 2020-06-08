package io.rayani.divar.controller;

import io.rayani.divar.entity.Client;
import io.rayani.divar.reposiory.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class ClientApi {
	
	@Autowired
	private ClientRepository clientRepository ;
	
	@GetMapping("/clients")
	public List<Client> getAllClient() {
		
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/get")
	public Page<Client> getClientPage(@RequestParam("page") int page , @RequestParam("size")int size){

		//Sort nom = Sort.by("nom");
		Pageable pageable =  PageRequest.of(page, size );

		return clientRepository.findAll(pageable);
	}
	@GetMapping("/list")
	public Page<Client> list(Pageable pageable){

		//Sort nom = Sort.by("nom");
//		Pageable pageable =  PageRequest.of(1, 10 );
		 return clientRepository.findAll(pageable);
	}
}
