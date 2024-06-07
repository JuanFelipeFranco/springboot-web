package com.felipe.spring_webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"","/","home"})
    public String home(){
        return "forward:/list";
        //return "redirect:/list"; //ruta que redirecciona al listado, ya que muestra el nuevo usuario agregado
    }
}
