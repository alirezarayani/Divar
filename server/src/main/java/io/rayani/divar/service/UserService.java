package io.rayani.divar.service;

import io.rayani.divar.entity.User;
import io.rayani.divar.exception.NotfoundException;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<? extends User> getUserByEmail(String email) throws NotfoundException;
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String email);


}
