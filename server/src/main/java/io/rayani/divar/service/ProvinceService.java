package io.rayani.divar.service;

import io.rayani.divar.entity.Province;
import io.rayani.divar.reposiory.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
