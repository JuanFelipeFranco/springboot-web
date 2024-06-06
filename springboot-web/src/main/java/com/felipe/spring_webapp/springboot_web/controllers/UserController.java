package com.felipe.spring_webapp.springboot_web.controllers;

import com.felipe.spring_webapp.springboot_web.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Juan","Franco");
        user.setEmail("felipe@gmail.com");
        model.addAttribute("title","Hola Mundo SpringBoot");
        model.addAttribute("user",user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("title","Listado de usuarios!");
        return "list";
    }

    @ModelAttribute("users")
    public List <User> usersModel(){
        return Arrays.asList(
                new User("Juan","Franco","juanfranco@gmail.com"),
                new User("Felipe","Rosas"),
                new User("Lina","Barrero","linaB@gmail.com"),
                new User("Andrea","Varela")
        );
    }



}
