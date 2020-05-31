package io.rayani.divar.service;

import io.rayani.divar.entity.User;
import io.rayani.divar.exception.NotfoundException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserByEmail(String email) throws NotfoundException;
    User getUserById(Long id);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(String email);
}
