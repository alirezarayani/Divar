package io.rayani.divar.service;

import io.rayani.divar.entity.Province;
import io.rayani.divar.reposiory.ProvinceRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceService {
    private final ProvinceRepository provinceRepository;
    @Autowired
    public ProvinceService(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }
    public List<Province> getAllProvince(){
        return  provinceRepository.findAll();
    }
    public Optional<Province> getProvince(Long id){
        Optional<Province> provinceById = provinceRepository.findById(id);
        if(provinceById.isPresent()){
            return provinceById;
        }
        return Optional.empty();
    }
}
