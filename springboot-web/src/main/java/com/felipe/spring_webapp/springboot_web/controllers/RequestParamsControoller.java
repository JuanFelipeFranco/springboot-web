package com.felipe.spring_webapp.springboot_web.controllers;

import com.felipe.spring_webapp.springboot_web.models.dto.ParamDto;
import com.felipe.spring_webapp.springboot_web.models.dto.ParamMixDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamsControoller {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto paramMixDto = new ParamMixDto();
        paramMixDto.setMessage(text);
        paramMixDto.setCode(code);
        return paramMixDto;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try{
            code = Integer.parseInt((request.getParameter("code")));
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        ParamMixDto params = new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
}
