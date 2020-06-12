package io.rayani.divar.service;

import io.rayani.divar.entity.Role;
import io.rayani.divar.entity.UserRole;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role findByRoleName(UserRole userRole);
}
