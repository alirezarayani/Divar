package io.rayani.divar.service;

import io.rayani.divar.controller.Response.ElectronicDeviceResponse;
import io.rayani.divar.entity.ElectronicDevice;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.reposiory.ElectronicDeviceRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ElectronicDeviceService {
    private static final Logger LOGGER= LoggerFactory.getLogger(ElectronicDeviceService.class);
    private final ElectronicDeviceRepository electronicDeviceRepository;
    private final ConvertDtoAndEntity convertDtoAndEntity;

    @Autowired
    public ElectronicDeviceService(ElectronicDeviceRepository electronicDeviceRepository, ConvertDtoAndEntity convertDtoAndEntity) {
        this.electronicDeviceRepository = electronicDeviceRepository;
        this.convertDtoAndEntity = convertDtoAndEntity;
    }


    public ElectronicDevice getElectronicDevice(Long id) {
        return electronicDeviceRepository.findById(id).get();
    }

    public Page<ElectronicDevice> getElectronics(Pageable pageable ) {
        return electronicDeviceRepository.findAll(pageable);
    }

    public List<ElectronicDeviceResponse> getElectronicDeviceByFk(Long id) {
        LOGGER.info("Inside getElectronicDeviceByFk() with id: "+id);
        List<ElectronicDevice> categoryList= electronicDeviceRepository.findByCategoryId(id);
        //convert entities to dtos
        List<ElectronicDeviceResponse> electronicDeviceResponseList = categoryList.stream().map(electronicDevice -> {
            return (ElectronicDeviceResponse) convertDtoAndEntity.convertEntityDto(electronicDevice, new ElectronicDeviceResponse());
        }).collect(Collectors.toList());
        return electronicDeviceResponseList;
    }

    public ElectronicDeviceResponse getElectronicDeviceByIdAndFk(Long electId,Long categoryId) throws NotfoundException {
        LOGGER.info(String.format("inside getElectronicDeviceByIdAndFk() with categoryId: %d and categoryId: %d",electId,categoryId));
        //CONVERT category entity to dto
        ElectronicDevice electronicDevice = electronicDeviceRepository
                .findByIdAndCategoryId(electId,categoryId)
                .orElseThrow(() -> {
                    return new NotfoundException("this id doesn't exists => "+electId);
                });
        ElectronicDeviceResponse electronicDeviceResponse=(ElectronicDeviceResponse) convertDtoAndEntity.convertEntityDto(electronicDevice, new ElectronicDeviceResponse());
        return electronicDeviceResponse;
    }
}

