package com.sasi.JobPortal.service;

import com.sasi.JobPortal.entity.User; // ADD THIS
import com.sasi.JobPortal.repository.UserRepository; // ADD THIS
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}