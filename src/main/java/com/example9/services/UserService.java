package com.example9.services;

import com.example9.entity.User;
import com.example9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void save(User user)
    {
        userRepository.save(user);
    }
}
