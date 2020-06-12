package io.rayani.divar.service;

import io.rayani.divar.security.model.UserDetailsImpl;
import io.rayani.divar.entity.User;
import io.rayani.divar.reposiory.UserRepository;
import io.rayani.divar.util.ConvertDtoAndEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class UserServiceImpl implements UserService  {


    private final UserRepository userRepository;
    private final ConvertDtoAndEntity convert;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConvertDtoAndEntity convert) {
        this.userRepository = userRepository;
        this.convert = convert;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", email))
                );
        return UserDetailsImpl.build(user);
    }

    @Override
    public User getUserByEmail(String email)  {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", email)));

        return user;
    }
    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
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


}
