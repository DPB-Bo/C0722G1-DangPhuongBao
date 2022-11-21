package com.example.controller;

import com.example.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
public class DisplayController {
    @Autowired
    private IDisplayService displayService;

    @GetMapping("")
    public String display(){
        return "display";
    }

    @PostMapping("/caculate")
    public String calculate(RedirectAttributes redirectAttributes, @RequestParam Double number1,@RequestParam Double number2,@RequestParam String sign){
        redirectAttributes.addFlashAttribute("number1",number1);
        redirectAttributes.addFlashAttribute("number2",number2);
        redirectAttributes.addFlashAttribute("result",displayService.calculate(number1,number2,sign));
        return "redirect:/";
    }
}
