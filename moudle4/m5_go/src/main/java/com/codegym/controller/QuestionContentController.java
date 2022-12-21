package com.codegym.controller;

import com.codegym.model.QuestionContent;
import com.codegym.repository.QuestionContentRepository;
import com.codegym.repository.QuestionTypeRepository;
import com.codegym.service.IQuestionContentService;
import com.codegym.service.IQuestionTypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;


@Controller
@RequestMapping("question")
public class QuestionContentController {
    private final IQuestionTypeService questionTypeRepository;
    private final IQuestionContentService questionContentService;

    public QuestionContentController(IQuestionTypeService questionTypeRepository, IQuestionContentService questionContentService) {
        this.questionTypeRepository = questionTypeRepository;
        this.questionContentService = questionContentService;
    }

    @GetMapping("")
    public String display(@PageableDefault(size = 5) Pageable pageable, Model model, @Validated QuestionContent questionContent, BindingResult bindingResult, @RequestParam(value = "searchTitle", defaultValue = "") String searchTitle, @RequestParam(value = "searchQuestionTypeId", defaultValue = "-1") int searchQuestionTypeId) {
        if (searchQuestionTypeId == -1) {
            model.addAttribute("questionList", questionContentService.findByTitleContaining(searchTitle, pageable));
        } else {
            model.addAttribute("questionList", questionContentService.findByTitleContainingAndQuestionType(searchTitle, questionTypeRepository.findById(searchQuestionTypeId), pageable));
        }
        model.addAttribute("questionTypeList", questionTypeRepository.findAll());
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchQuestionTypeId", searchQuestionTypeId);
        model.addAttribute("questionContent", questionContent);
        return "display";
    }

    @PostMapping("")
    public String addNew(@PageableDefault(size = 5) Pageable pageable, Model model, @Validated @ModelAttribute QuestionContent questionContent, BindingResult bindingResult, @RequestParam(value = "searchTitle", defaultValue = "") String searchTitle, @RequestParam(value = "searchQuestionTypeId", defaultValue = "-1") int searchQuestionTypeId) {
        if (searchQuestionTypeId == -1) {
            model.addAttribute("questionList", questionContentService.findByTitleContaining(searchTitle, pageable));
        } else {
            model.addAttribute("questionList", questionContentService.findByTitleContainingAndQuestionType(searchTitle, questionTypeRepository.findById(searchQuestionTypeId), pageable));
        }
        model.addAttribute("questionTypeList", questionTypeRepository.findAll());
        model.addAttribute("searchTitle", searchTitle);
        model.addAttribute("searchQuestionTypeId", searchQuestionTypeId);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionContent", questionContent);
            model.addAttribute("hasErrorsAdd", true);
            model.addAttribute("statusCode", 1);
            return "display";
        }
        questionContent.setDate_create(Date.valueOf(LocalDate.now()).toString());
        model.addAttribute("msg", "Thêm mới thành công");
        questionContentService.save(questionContent);
        return "redirect:/question";
    }

    @PostMapping("delete")
    public String delete(@RequestParam("deleteQuestionId") int id, RedirectAttributes redirectAttributes) {
        questionContentService.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Xoá thành công");
        return "redirect:/question";
    }
}
