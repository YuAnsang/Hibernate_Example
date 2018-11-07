package com.github.as.service;

import java.util.List;
import com.github.as.data.entity.User;

public interface UserService {

    public void add(User user);
    
    public User getUser(String id);
    
    public List<User> getUserList();
}
