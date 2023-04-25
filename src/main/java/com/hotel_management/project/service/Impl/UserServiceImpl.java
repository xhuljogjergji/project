package com.hotel_management.project.service.Impl;

import com.hotel_management.project.dto.user.UserDTO;
import com.hotel_management.project.dto.user.UserUpdateDTO;
import com.hotel_management.project.entity.user.User;
import com.hotel_management.project.entity.user.UserRole;
import com.hotel_management.project.exception.ResourceNotFoundException;
import com.hotel_management.project.mapper.UserMapper;
import com.hotel_management.project.repository.UserRepository;
import com.hotel_management.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) {
//        Optional<User> user=userRepository.findById(id);
//        if (user.isPresent()){
//            return user.get();
//        }else {
//            throw new ResourceNotFoundException(String.format("User with id %snot found", id));
//        }
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.
                format("User with id %snot found", id)));
    }


    @Override
    public User updateUser(User user, Integer id) {
        User user1=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(String.
                format("User with id %snot found", id)));
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setPhoneNo(user.getPhoneNo());
        userRepository.save(user1);
        return user1;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));
        userRepository.deleteById(id);
    }


}

