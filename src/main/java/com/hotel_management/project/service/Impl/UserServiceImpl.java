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
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDTO registerUser(UserDTO req,String userRole) {
        User u=UserMapper.toEntity(req);
        u.setRole(userRole!=null?UserRole.fromValue(userRole):UserRole.GUEST);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDto(u);
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
    public UserUpdateDTO updateUser(UserUpdateDTO req, Integer id) {
        User u = findById(id);
        u = UserMapper.buildUpdateUser(u,req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String
                        .format("User with id %s not found",id)));
        userRepository.deleteById(id);
    }

    @Override
    public User getUserFromToken(Jwt jwt) {
        String sub = (String) jwt.getClaims().get("sub");
        return userRepository.findByEmail(sub).get();
    }

    @Override
    public UserDTO createUser(UserDTO req) {
        User u=new User();
        u.setFirstName(u.getFirstName());
        u.setLastName(u.getLastName());
        u.setEmail(u.getEmail());
        u.setPassword(u.getPassword());
        u.setRole(u.getRole());
        userRepository.save(u);
        return UserMapper.toDto(u);
    }


}

