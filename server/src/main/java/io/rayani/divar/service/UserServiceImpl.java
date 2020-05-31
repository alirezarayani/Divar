package io.rayani.divar.service;

import io.rayani.divar.entity.User;
import io.rayani.divar.exception.NotfoundException;
import io.rayani.divar.reposiory.UserRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConvertDtoAndEntity convert;

    public UserServiceImpl(UserRepository userRepository, ConvertDtoAndEntity convert) {
        this.userRepository = userRepository;
        this.convert = convert;
    }
    @Override
    public User getUserByEmail(String email) throws NotfoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() ->{ return new  NotfoundException("this email dosen't exist");} );
        return user;
    }
    @Override
    public List<User> getAllUsers() {
        return null;
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }

}
