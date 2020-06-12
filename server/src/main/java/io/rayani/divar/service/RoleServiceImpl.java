package io.rayani.divar.service;

import io.rayani.divar.entity.Role;
import io.rayani.divar.entity.UserRole;
import io.rayani.divar.exception.RoleNotFoundException;
import io.rayani.divar.reposiory.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findByRoleName(UserRole userRole) {
        Role role = roleRepository.findByUserRole(userRole).orElseThrow(
                () -> new RoleNotFoundException("Error: Role is not found.")
        );
        return role;
    }
}
