package com.example.controller;

import com.example.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("display")
public class DisplayController {
    @Autowired
    private IDisplayService displayService;

    @GetMapping(value = "")
    public String showDisplay(){
        return "display";
    }

    @PostMapping(value = "")
    public String calculate(ModelMap modelMap,@RequestParam(defaultValue = "0") Integer usdValue){
        modelMap.addAttribute("usdValue",usdValue);
        modelMap.addAttribute("result",displayService.calculate(usdValue));
        return "display";
    }
}