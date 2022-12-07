package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {
    @GetMapping("")
    public String display(){
        return "index";
    }
    @GetMapping("/user")
    public String goUserPage(){
        return "user_page";
    }

    @GetMapping("/admin")
    public String goAdminPage(){
        return "admin_page";
    }

    @GetMapping("/error_role")
    public String goErrorRolePage(){
        return "denied_error_page";
    }

    @GetMapping("/logined")
    public String goRolePage(){
        return "logined_page";
    }

    @GetMapping("/logout")
    public String goLogoutPage(){
        return "logout_page";
    }
}
