package com.felipe.spring_webapp.springboot_web.controllers;

import com.felipe.spring_webapp.springboot_web.models.User;
import com.felipe.spring_webapp.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valueList;
    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String product;

    @Value("#{${config.valuesMap}.price}")
    private Long price;

    @Autowired
    private Environment environment;
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

    @GetMapping("/values")
    public Map<String, Object> values(){
        Long code2 = environment.getProperty("config.code", Long.class);
        
        Map<String,Object> json = new HashMap<>();
        json.put("username",username);
        json.put("code",code);
        json.put("code2",code2);
        json.put("message",message);
        json.put("message2",environment.getProperty("config.message"));
        json.put("listOfValues",listOfValues);
        json.put("valueList",valueList);
        json.put("valueString",valueString);
        json.put("valueMap",valuesMap);
        json.put("product",product);
        json.put("price",price);
        return json;
    }





}
