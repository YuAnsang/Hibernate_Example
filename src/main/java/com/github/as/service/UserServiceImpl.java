package com.github.as.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.as.data.entity.User;
import com.github.as.data.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void add(User user) {
        // TODO Auto-generated method stub
    }
    
    @Override
    public User getUser(String id) {
        return userRepository.findOne(id);
    }
    
    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
