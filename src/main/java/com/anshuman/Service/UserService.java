package com.anshuman.Service;

import com.anshuman.DTO.Request.UserRequest;
import com.anshuman.DTO.Response.UserResponse;
import com.anshuman.entity.User;
import com.anshuman.storage.UserRepository;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findById(id).get();
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        return response;
    }
    public UserResponse updateUser(UserRequest request){
    	UserResponse response = new UserResponse();
    	response.setName(request.getName());
    	response.setAge(request.getAge());
    	return response;
    }
}
