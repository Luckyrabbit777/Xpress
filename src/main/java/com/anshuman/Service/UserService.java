package com.anshuman.Service;

import com.anshuman.DTO.Request.UserRequest;
import com.anshuman.DTO.Response.UserResponse;
import com.anshuman.entity.User;
import com.anshuman.storage.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserResponse registerUser(UserRequest request) {
        UserResponse response = new UserResponse();
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);
        response.setId(savedUser.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMessage("User Registered Successfully");
        return response;
    }

    public UserResponse getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Doesn't Exist");
        }
        User user = optionalUser.get();
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }
    public UserResponse updateUser(UserRequest request, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Doesn't Exist");
        }
        optionalUser.get().setName(request.getName());
        optionalUser.get().setAge(request.getAge());

        User savedUser = userRepository.save(optionalUser.get());
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
    	return response;
    }
}
