package com.adv.price.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String home(){

        System.out.println("home page...");

        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){

        System.out.println("welcome page...");

        return "welcome";
    }



    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("1"));
    }
}
