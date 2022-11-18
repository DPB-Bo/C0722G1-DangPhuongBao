package com.example.controller;

import com.example.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("display")
public class DisplayController {

    @Autowired
    private IDisplayService displayService;

    @RequestMapping("")
    public String getViWord(ModelMap modelMap, String enWord){
        modelMap.addAttribute("enWord", enWord);
        modelMap.addAttribute("viWord", displayService.getViWord(enWord));
        return "display";
    }
}
