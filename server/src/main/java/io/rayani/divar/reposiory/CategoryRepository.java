package io.rayani.divar.reposiory;

import io.rayani.divar.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
