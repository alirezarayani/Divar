package io.rayani.divar.reposiory;

import io.rayani.divar.entity.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice,Long> {

}
