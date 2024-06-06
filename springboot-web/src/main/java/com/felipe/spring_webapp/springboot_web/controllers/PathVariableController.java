package com.felipe.spring_webapp.springboot_web.controllers;

import com.felipe.spring_webapp.springboot_web.models.User;
import com.felipe.spring_webapp.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathaVar(@PathVariable String product, @PathVariable Long id){
        Map<String,Object> json = new HashMap<>();
        json.put("product",product);
        json.put("id",id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
        //hacer algo con el usuario save en la DB
        user.setName(user.getName().toUpperCase());
        return user;
    }



}
