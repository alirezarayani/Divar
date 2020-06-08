package io.rayani.divar.service;

import io.rayani.divar.security.ApplicationUser;
import io.rayani.divar.entity.User;
import io.rayani.divar.reposiory.UserRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService  {
    private final UserRepository userRepository;
    private final ConvertDtoAndEntity convert;

    public UserServiceImpl(UserRepository userRepository, ConvertDtoAndEntity convert) {
        this.userRepository = userRepository;
        this.convert = convert;
    }
    @Override
    public Optional<User> getUserByEmail(String email)  {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user;
        }
        return Optional.empty();
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
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String email) {

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", email))
                );
        return new ApplicationUser(user);

    }
}
