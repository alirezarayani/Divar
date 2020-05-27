package io.rayani.divar.reposiory;

import io.rayani.divar.entity.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Repository
@CrossOrigin("http://localhost:4200")

public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice,Long> {
        List<ElectronicDevice> findByCategoryId(Long id);
        Optional<ElectronicDevice> findByIdAndCategoryId(Long electronicId, Long id);
}
