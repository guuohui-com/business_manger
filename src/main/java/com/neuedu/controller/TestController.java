package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    public String login(){
        System.out.println("=====================");
        return "login";
    }
}
