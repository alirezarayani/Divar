package io.rayani.divar.service;

import io.rayani.divar.controller.Response.ElectronicDeviceResponse;
import io.rayani.divar.entity.ElectronicDevice;
import io.rayani.divar.reposiory.ElectronicDeviceRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ElectronicDeviceService {

    private final ElectronicDeviceRepository electronicDeviceRepository;
    private final ConvertDtoAndEntity convertDtoAndEntity;

    @Autowired
    public ElectronicDeviceService(ElectronicDeviceRepository electronicDeviceRepository, ConvertDtoAndEntity convertDtoAndEntity) {
        this.electronicDeviceRepository = electronicDeviceRepository;
        this.convertDtoAndEntity = convertDtoAndEntity;
    }

    public List<ElectronicDeviceResponse> getElectronicS() {
        List<ElectronicDevice> electronicAll = electronicDeviceRepository.findAll();
        List<ElectronicDeviceResponse> collect = electronicAll.stream().map(electronicDevice ->
                (ElectronicDeviceResponse) convertDtoAndEntity.convertEntityDto(electronicDevice, new ElectronicDeviceResponse()))
                .collect(Collectors.toList());
        return collect;
    }
}

