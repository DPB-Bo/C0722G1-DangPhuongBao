package com.example.controller;

import com.example.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("display")
public class DisplayController {
    @Autowired
    private IDisplayService displayService;

    @RequestMapping(value = "")
    public String showDisplay(ModelMap modelMap,@RequestParam(defaultValue = "0") Integer usdValue){
        modelMap.addAttribute("result",displayService.calculate(usdValue));
        modelMap.addAttribute("usdValue",usdValue);
        return "display";
    }
}