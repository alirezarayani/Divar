package io.rayani.divar.reposiory;

import io.rayani.divar.entity.Role;
import io.rayani.divar.entity.User;
import io.rayani.divar.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByUserRole(UserRole roleName);
}
