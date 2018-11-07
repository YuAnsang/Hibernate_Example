package com.github.as;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.github.as.config.HibernateConfiguration;
import com.github.as.config.RootContextConfiguration;
import com.github.as.config.ServletConfiguration;
import com.github.as.config.WebApplicationConfiguration;
import com.github.as.data.entity.User;
import com.github.as.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ServletConfiguration.class, RootContextConfiguration.class, WebApplicationConfiguration.class, HibernateConfiguration.class})
@Transactional
public class UserTest {

    @Autowired
    private UserService userService;
    
    @Test
    public void testGetUsers() {
        // Get Users
        List<User> users = userService.getUserList();
        for (User user : users) {
           System.out.println("Id = "+ user.getId());
           System.out.println("Name = "+user.getUserName());
           System.out.println("Email = "+user.getEmail());
           System.out.println();
        }
    }
}
