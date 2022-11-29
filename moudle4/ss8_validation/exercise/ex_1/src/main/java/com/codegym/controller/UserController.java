package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String display(@PageableDefault(page = 0,size = 3) Pageable pageable, Model model, @Valid User user, BindingResult bindingResult){
        model.addAttribute("user", user);
        model.addAttribute("userList",userService.findByEmailContaining(pageable));
        return "create_user";
    }

    @PostMapping("save")
    public String validateUser(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, @PageableDefault(page = 0,size = 3) Pageable pageable, Model model){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors", true);
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/";
        }
        userService.save(user);
        return "redirect:/";
    }
}
