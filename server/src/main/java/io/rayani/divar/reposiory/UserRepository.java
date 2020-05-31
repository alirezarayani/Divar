package io.rayani.divar.reposiory;

import io.rayani.divar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(@Param("email") String email);
//    @Query(value="SELECT * FROM user where email =:email",nativeQuery = true)

//    @Query(value="SELECT * FROM user where first_name = :firstName",nativeQuery = true)
//    User findByFirstName(@Param("firstName") String email);
}
