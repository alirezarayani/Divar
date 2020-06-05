package io.rayani.divar.service;

import io.rayani.divar.entity.User;
import io.rayani.divar.exception.NotfoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService  {
    List<User> getAllUsers();
    Optional<? extends User> getUserByEmail(String email) throws NotfoundException;
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String email);
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

}
