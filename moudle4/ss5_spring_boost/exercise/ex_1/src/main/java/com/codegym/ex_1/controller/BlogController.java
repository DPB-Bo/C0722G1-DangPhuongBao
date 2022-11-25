package com.codegym.ex_1.controller;

import com.codegym.ex_1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView display(@RequestParam(defaultValue = "") String search){
        ModelAndView modelAndView = new ModelAndView("display");
        modelAndView.addObject("search",search);
        modelAndView.addObject("blogList",blogService.findByTitleContainingOrAuthorContaining(search));
        return modelAndView;
    };

    @GetMapping("save")
    public String save(@RequestParam Integer id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }
}
