package io.rayani.divar.reposiory;

import io.rayani.divar.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Long> {
}
