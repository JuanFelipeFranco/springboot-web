package com.felipe.spring_webapp.springboot_web.controllers;

import com.felipe.spring_webapp.springboot_web.models.User;
import com.felipe.spring_webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Juan","Franco");
        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola mundo Spring");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user=new User("Juan","Franco");
        User user2=new User("Felipe","Rosas");
        User user3=new User("Juan Felipe","Franco Rosas");

        List<User> users = Arrays.asList(user,user2,user3);
        /*List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);*/

        return users;
    }
    @GetMapping("/details-map")
    public Map<String,Object> detailsMap(){
        User user = new User("Juan","Franco");
        Map<String, Object> body = new HashMap<>();

        body.put("title","Hola Mundo Spring");
        body.put("user", user);
        return body;
    }
}
