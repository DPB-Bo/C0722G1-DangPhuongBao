package com.example.controller;

import com.example.model.MailForm;
import com.example.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("")
public class MailController {
    @Autowired
    private IMailService mailService;

    @GetMapping("")
    public ModelAndView display() {
        ModelAndView model = new ModelAndView("mail_form/display");
        model.addObject("mailFormList", mailService.getAvailable());
        return model;
    }

    @GetMapping("update")
    public ModelAndView update(@RequestParam("id") Integer id) {
        ModelAndView model = new ModelAndView("mail_form/update");
        List<String> languageNameList = Arrays.asList("English", "Vietnamese", "Japanese", "Chinese");
        List<Integer> pageSizeList = Arrays.asList(5, 10, 15, 20, 25);
        model.addObject("pageSizeList", pageSizeList);
        model.addObject("languageNameList", languageNameList);
        model.addObject("mailForm", mailService.findById(id));
        return model;
    }

    @PostMapping("update")
    public String update(MailForm mailForm) {
        mailService.editMailFrom(mailForm);
        return "redirect:/";
    }
}
