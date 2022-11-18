package com.example.controller;

import com.example.service.IDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("display")
public class DisplayController {

    @Autowired
    private IDisplayService displayService;

    @GetMapping(value = "")
    public String getViWord(){
        return "display";
    }

    @PostMapping(value="/find")
    public String showResult(ModelMap modelMap, String enWord){
        modelMap.addAttribute("enWord", enWord);
        modelMap.addAttribute("viWord", displayService.getViWord(enWord));
        return "display";
    }
}
