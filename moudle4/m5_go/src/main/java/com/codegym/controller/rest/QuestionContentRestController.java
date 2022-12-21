package com.codegym.controller.rest;

import com.codegym.model.QuestionContent;
import com.codegym.service.IQuestionContentService;
import com.codegym.service.IQuestionTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rest")
@CrossOrigin("*")
public class QuestionContentRestController {
    private final IQuestionTypeService questionTypeRepository;
    private final IQuestionContentService questionContentService;

    public QuestionContentRestController(IQuestionTypeService questionTypeRepository, IQuestionContentService questionContentService) {
        this.questionTypeRepository = questionTypeRepository;
        this.questionContentService = questionContentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionContent> get(@PathVariable("id") int id) {
        return new ResponseEntity<>(questionContentService.findById(id), HttpStatus.OK);
    }
}
