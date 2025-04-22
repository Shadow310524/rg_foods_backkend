package com.example.rg.rg_foods_backend.service;

import com.example.rg.rg_foods_backend.model.LoginRequest;
import com.example.rg.rg_foods_backend.model.User;
import com.example.rg.rg_foods_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder encoder;
//Get All Users
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println("User Password: " + user.getPassword());
        System.out.println("User to be added: " + user.toString());
        System.out.println("User Address "+user.getAddress());
        System.out.println("User email "+user.getEmail());
        userRepo.save(user);
    }

    public boolean getUserbyEmail(LoginRequest req){
        String email=req.getEmail();
        String password=req.getPassword();
        User user=userRepo.findByEmail(email);
//        System.out.println(user.toString());
        if(user!=null && encoder.matches(password,user.getPassword()))
            return true;
        return false;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
