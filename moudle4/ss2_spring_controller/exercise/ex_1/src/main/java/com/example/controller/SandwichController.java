package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("")
public class SandwichController {
    @GetMapping("")
    public String display() {
        return "display";
    }

    @PostMapping("/showSeasonings")
    public String showSeasonings(RedirectAttributes redirectAttributes, @RequestParam("checkSeasonings") String[] seasonList) {
        redirectAttributes.addFlashAttribute("listSeasonings", seasonList);
        return "redirect:/";
    }
}
