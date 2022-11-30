package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
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

    @GetMapping("validList")
    public String display(@PageableDefault(page = 0,size = 3) Pageable pageable, Model model, @Valid UserDto userDto, BindingResult bindingResult){
        model.addAttribute("userDto", userDto);
        model.addAttribute("userDtoList",userService.findByEmailContaining(pageable));
        return "create_user";
    }
    @GetMapping("")
    public String display(@PageableDefault(page = 0,size = 3) Pageable pageable, Model model, UserDto userDto){
        model.addAttribute("userDto", userDto);
        model.addAttribute("userDtoList",userService.findByEmailContaining(pageable));
        return "create_user";
    }

    @PostMapping("save")
    public String validateUser(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, @PageableDefault(page = 0,size = 3) Pageable pageable, Model model){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors", true);
            redirectAttributes.addFlashAttribute("userDto", userDto);
            return "redirect:/validList";
        }
        User user = User.builder().build();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        return "redirect:/";
    }
}
